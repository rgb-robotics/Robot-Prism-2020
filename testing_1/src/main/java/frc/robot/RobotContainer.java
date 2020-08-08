/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.DriveSubsystem_FF;
//import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.FeederSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.ShooterSubsystemForTesting;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.wpilibj2.command.ProfiledPIDCommand;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  //The robot's joystick(s) and controller(s) are declared here.
  public static final Joystick m_stick = new Joystick(Constants.OIPorts.kStickPort);
  public static final XboxController m_controller = new XboxController(Constants.OIPorts.kControllerPort);

  //The robot's subsystems are declared here.
  //private static final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private static final DriveSubsystem_FF m_driveSubsystem_FF = new DriveSubsystem_FF();
  private static final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  private static final FeederSubsystem m_feederSubsystem = new FeederSubsystem();
  private static final ShooterSubsystem m_shooterSubsystem = new ShooterSubsystem();
  private static final ShooterSubsystemForTesting m_shooterSubsystemForTesting = new ShooterSubsystemForTesting();

  //The robot's commands are declared here.
  private static final RunCommand m_arcadeDrive = new RunCommand(() -> m_driveSubsystem_FF.arcadeDrive(-m_stick.getY(), m_stick.getX(), m_stick.getThrottle()));
  //private static final SequentialCommandGroup m_driveDistanceCommandPID = new SequentialCommandGroup(new InstantCommand(m_driveSubsystem::resetEncoders, m_driveSubsystem), new PIDCommand(new PIDController(Constants.PIDConstants.DriveSubsystem.kP, Constants.PIDConstants.DriveSubsystem.kI, Constants.PIDConstants.DriveSubsystem.kD), m_driveSubsystem::getDistanceDriven, 24, output -> m_driveSubsystem.drive(output, 0, -1), m_driveSubsystem));
  //private static final SequentialCommandGroup m_driveDistanceCommandMPPID = new SequentialCommandGroup(new InstantCommand(m_driveSubsystem::resetEncoders, m_driveSubsystem), new ProfiledPIDCommand(new ProfiledPIDController(Constants.PIDConstants.DriveSubsystem.kP, Constants.PIDConstants.DriveSubsystem.kI, Constants.PIDConstants.DriveSubsystem.kD, new TrapezoidProfile.Constraints(0, 0)), m_driveSubsystem::getDistanceDriven, 24, (output, setpoint) -> m_driveSubsystem.drive(output, 0, -1), m_driveSubsystem));
  //private static final SequentialCommandGroup m_driveDistanceCommandPID = new SequentialCommandGroup(new InstantCommand(m_driveSubsystem_FF::resetEncoders, m_driveSubsystem_FF), new PIDCommand(new PIDController(Constants.PIDConstants.DriveSubsystem.kP, Constants.PIDConstants.DriveSubsystem.kI, Constants.PIDConstants.DriveSubsystem.kD), m_driveSubsystem_FF::getDistanceDriven, 24, output -> m_driveSubsystem_FF.arcadeDrive(output, 0, -1), m_driveSubsystem_FF));
  private static final SequentialCommandGroup m_driveDistanceCommandMPPID = new ProfiledPIDCommand(new ProfiledPIDController(Constants.PIDConstants.DriveSubsystem.kP, Constants.PIDConstants.DriveSubsystem.kI, Constants.PIDConstants.DriveSubsystem.kD, new TrapezoidProfile.Constraints(0, 0)), m_driveSubsystem_FF::getDistanceDriven, 24, (output, setpoint) -> m_driveSubsystem_FF.voltageDrive(m_driveSubsystem_FF.FFOutput(setpoint) + output, -m_driveSubsystem_FF.FFOutput(setpoint) - output), m_driveSubsystem_FF).beforeStarting(m_driveSubsystem_FF::resetEncoders, m_driveSubsystem_FF);
  private static final StartEndCommand m_intakeRunStop = new StartEndCommand(m_intakeSubsystem::intakeRun, m_intakeSubsystem::intakeStop, m_intakeSubsystem);
  private static final StartEndCommand m_intakeDownUp = new StartEndCommand(m_intakeSubsystem::intakeDown, m_intakeSubsystem::intakeUp, m_intakeSubsystem);
  private static final StartEndCommand m_feederUp = new StartEndCommand(m_feederSubsystem::feederUp, m_feederSubsystem::feederStop, m_feederSubsystem);
  private static final StartEndCommand m_feederDown = new StartEndCommand(m_feederSubsystem::feederDown, m_feederSubsystem::feederStop, m_feederSubsystem);
  private static final StartEndCommand m_feederStopperUpDown = new StartEndCommand(m_feederSubsystem::feederStopperDown, m_feederSubsystem::feederStopperUp, m_feederSubsystem); 
  //private static final StartEndCommand m_shooterRunStop = new StartEndCommand(m_shooterSubsystem::enable, m_shooterSubsystem::disable, m_shooterSubsystem);

  private static final StartEndCommand m_shooterRunStop = new StartEndCommand(m_shooterSubsystemForTesting::periodic, m_shooterSubsystemForTesting::stop, m_shooterSubsystemForTesting);

  //The robot's buttons are declared here.
  JoystickButton m_controllerA = new JoystickButton(m_controller, XboxController.Button.kA.value);
  JoystickButton m_controllerB = new JoystickButton(m_controller, XboxController.Button.kB.value);
  Trigger m_controllerRT = new Trigger(() -> m_controller.getTriggerAxis(GenericHID.Hand.kRight) > 0.9);
  JoystickButton m_joystick1 = new JoystickButton(m_stick, Joystick.ButtonType.kTrigger.value);
  JoystickButton m_joystick3 = new JoystickButton(m_stick, 3);
  JoystickButton m_joystick4 = new JoystickButton(m_stick, 4);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    //m_driveSubsystem.setDefaultCommand(new DriveCommand(m_driveSubsystem, () -> -m_stick.getY(), () -> m_stick.getX(), () -> m_stick.getThrottle()));
    //TODO If the RunCommand below works, then delete the DriveCommand. And then initializes the command instead of anonymous.
    m_driveSubsystem_FF.setDefaultCommand(m_arcadeDrive);
  
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //Configure the button bindings here.
    m_controllerA.toggleWhenPressed(m_intakeRunStop);
    m_controllerRT.toggleWhenActive(m_intakeDownUp);

    m_joystick3.whenHeld(m_feederUp);
    m_joystick4.whenHeld(m_feederDown);
    m_joystick1.toggleWhenPressed(m_feederStopperUpDown);

    m_controllerB.toggleWhenPressed(m_shooterRunStop);
  }

  public Command getAutonomousCommand() {
    //return m_driveDistanceCommandPID;
    return m_driveDistanceCommandMPPID;
  }
}
