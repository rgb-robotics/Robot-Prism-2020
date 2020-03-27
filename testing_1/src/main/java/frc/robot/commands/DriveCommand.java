/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.RobotContainer;

public class DriveCommand extends CommandBase {

  private final DriveSubsystem DriveSubsystem;
  
  public DriveCommand(DriveSubsystem m_driveSubsystem) {
    DriveSubsystem = m_driveSubsystem;
    //addRequirements(m_driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = -RobotContainer.stick.getY();
    double rotation = RobotContainer.stick.getX();
    double scale = -0.13*(RobotContainer.stick.getThrottle())+0.67;
    DriveSubsystem.drive(speed, rotation, scale);
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
