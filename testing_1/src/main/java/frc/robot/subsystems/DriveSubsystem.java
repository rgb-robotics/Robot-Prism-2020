/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;


public class DriveSubsystem extends SubsystemBase {

  private static Spark leftMotorA = new Spark(RobotMap.leftMotorA);
  private static Spark leftMotorB = new Spark(RobotMap.leftMotorB);
  private static Spark leftMotorC = new Spark(RobotMap.leftMotorC);
  private static Spark rightMotorA = new Spark(RobotMap.rightMotorA);
  private static Spark rightMotorB = new Spark(RobotMap.rightMotorB);
  private static Spark rightMotorC = new Spark(RobotMap.rightMotorC);
  private static SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftMotorA, leftMotorB, leftMotorC);
  private static SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightMotorA, rightMotorB, rightMotorC);
  private static DifferentialDrive drive = new DifferentialDrive(leftMotors, rightMotors);

  public void drive(double speed, double rotation) {
    drive.arcadeDrive(speed, rotation);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}