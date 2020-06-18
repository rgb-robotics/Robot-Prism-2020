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
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.FeederSubsystem;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.commands.IntakeCommand_1;
import frc.robot.commands.IntakeCommand_2;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  //The robot's subsystems are defined here.
  private static final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private static final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private static final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private static final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  private static final FeederSubsystem m_feederSubsystem = new FeederSubsystem();

  //The robot's joystick(s) and controller(s) are defined here.
  public static final Joystick m_stick = new Joystick(Constants.ControllerPorts.kStickPort);
  public static final XboxController m_controller = new XboxController(Constants.ControllerPorts.kControllerPort);

  //Create the button bindings here.
  JoystickButton controllerA = new JoystickButton(m_controller, 1);
  JoystickButton controllerRT = new JoystickButton(m_controller, 12);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    //Set the default commands here. Configure the button bindings here.
    m_driveSubsystem.setDefaultCommand(new DriveCommand(m_driveSubsystem, () -> m_stick.getThrottle(), () -> -m_stick.getY(), () -> m_stick.getX()));
    
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
    controllerA.whenPressed(m_intakeSubsystem::intakeRunStop);
    controllerRT.whenPressed(m_intakeSubsystem::intakeDownUp);
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
