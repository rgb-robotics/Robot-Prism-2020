/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommandCopy extends CommandBase {

  //Create local variables for the class here. Define the local variables to be the value of the instance variables.
  private static DriveSubsystem m_driveSubsystem;
  private static double m_scale;
  private static double m_speed;
  private static double m_rotation;
  public DriveCommandCopy(DriveSubsystem driveSubsystem, double scale, double speed, double rotation) {
    m_driveSubsystem = driveSubsystem;
    m_scale = -0.13 * scale + 0.67;
    m_speed = speed * m_scale;
    m_rotation = rotation * m_scale;

    //Require the instance of the subsystem here.
    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_driveSubsystem.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute(){
    m_driveSubsystem.drive(m_speed, m_rotation);
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
