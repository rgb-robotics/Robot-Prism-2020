/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeSubsystem;
import java.util.function.BooleanSupplier;

public class IntakeCommand extends CommandBase {
  
  //Create local variables for the class here.
  private static IntakeSubsystem m_intakeSubsystem;
  private static BooleanSupplier m_intake;
  private static BooleanSupplier m_intakeElevation;
  private static boolean intakeStat; //true=run, false=stop
  private static boolean m_intakeElevationStat; //true=down, false=up

  //Define the local variables to be the value of the instance variables.
  public IntakeCommand(IntakeSubsystem intakeSubsystem, BooleanSupplier intake, BooleanSupplier intakeElevation) {
    m_intakeSubsystem = intakeSubsystem;
    m_intake = intake;
    m_intakeElevation = intakeElevation;

    addRequirements(intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intakeStat = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute(){
    if (m_intake.getAsBoolean() == true) {
      intakeStat = !intakeStat;
    }
    if (intakeStat == true) {
      m_intakeSubsystem.intakeRun();
    }
    if (intakeStat == false) {
      m_intakeSubsystem.intakeStop();
    }
    System.out.println(m_intake.getAsBoolean());

    /*
    if (m_intakeStat = true) {
      
    }
    m_intakeSubsystem.intake(m_intakeStat);

    if (m_intakeElevationStat = true) {
      
    }
    m_intakeSubsystem.intakeElevation(m_intakeElevationStat);
    */
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}