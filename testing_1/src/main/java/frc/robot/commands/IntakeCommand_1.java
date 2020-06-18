/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand_1 extends CommandBase {
  
  //Create local variables for the class here.
  private static IntakeSubsystem m_intakeSubsystem;
  private static boolean m_intakeStat = false; //true=run, false=stop

  public IntakeCommand_1(IntakeSubsystem intakeSubsystem) {
    m_intakeSubsystem = intakeSubsystem;
    addRequirements(intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute(){
    m_intakeStat = !m_intakeStat;
    if (m_intakeStat) {
      m_intakeSubsystem.intakeRun();
    } 
    else {
      m_intakeSubsystem.intakeStop();
    }
    System.out.println(m_intakeStat);
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