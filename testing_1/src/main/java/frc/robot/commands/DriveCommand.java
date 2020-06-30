/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends CommandBase {

  //Create local variables for the class here.
  private static DriveSubsystem m_driveSubsystem;
  private static DoubleSupplier m_scale;
  private static DoubleSupplier m_speed;
  private static DoubleSupplier m_rotation;

  //Define the local variables to be the value of the instance variables.
  public DriveCommand(DriveSubsystem driveSubsystem, DoubleSupplier speed, DoubleSupplier rotation, DoubleSupplier scale) {
    m_driveSubsystem = driveSubsystem;
    m_speed = speed;
    m_rotation = rotation;
    m_scale = scale;

    addRequirements(m_driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_driveSubsystem.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute(){
    m_driveSubsystem.drive(-m_speed.getAsDouble(), m_rotation.getAsDouble(), m_scale.getAsDouble());
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
