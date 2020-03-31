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

public class DriveCommand extends CommandBase {

  private final DriveSubsystem DriveSubsystem;
  
  private double speed;
  private double rotation;
  private double scale;
  private double finalSpeed;
  private double finalRotation;
  private double finalScale;

  public DriveCommand(DriveSubsystem driveSubsystem) {
    DriveSubsystem = driveSubsystem;
    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute(){
    speed = RobotContainer.stick.getY() * scale;
    rotation = RobotContainer.stick.getX() * scale;
    scale = -0.13 * RobotContainer.stick.getThrottle() + 0.67;
    DriveSubsystem.drive(speed , rotation );
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
