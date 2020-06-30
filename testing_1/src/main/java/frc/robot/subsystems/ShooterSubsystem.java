/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.Constants;

public class ShooterSubsystem extends PIDSubsystem {

  public ShooterSubsystem() {
    super (new PIDController(Constants.PIDConstants.ShooterSubsystem.kP, Constants.PIDConstants.ShooterSubsystem.kI, Constants.PIDConstants.ShooterSubsystem.kD));
  }

  @Override
  protected void useOutput(double output, double setpoint) {
    // TODO Auto-generated method stub

  }

  @Override
  protected double getMeasurement() {
    // TODO Auto-generated method stub
    return 0;
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
