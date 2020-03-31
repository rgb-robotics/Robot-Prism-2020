/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;

public class DriveSubsystem extends SubsystemBase {

  private static Spark leftMotorA = new Spark(Constants.DriveMotorPorts.kLeftMotorA);
  private static Spark leftMotorB = new Spark(Constants.DriveMotorPorts.kLeftMotorB);
  private static Spark leftMotorC = new Spark(Constants.DriveMotorPorts.kLeftMotorC);
  private static Spark rightMotorA = new Spark(Constants.DriveMotorPorts.kRightMotorA);
  private static Spark rightMotorB = new Spark(Constants.DriveMotorPorts.kRightMotorB);
  private static Spark rightMotorC = new Spark(Constants.DriveMotorPorts.kRightMotorC);
  private static SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftMotorA, leftMotorB, leftMotorC);
  private static SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightMotorA, rightMotorB, rightMotorC);
  private static DifferentialDrive drive = new DifferentialDrive(leftMotors, rightMotors);
  private static Encoder leftEncoder = new Encoder(Constants.EncoderPorts.kDriveLeftEncoderA, Constants.EncoderPorts.kDriveLeftEncoderB, false, EncodingType.k4X);
  private static Encoder rightEncoder = new Encoder(Constants.EncoderPorts.kDriveRightEncoderA, Constants.EncoderPorts.kDriveRightEncoderB, true, EncodingType.k4X);

  public void drive(double speed, double rotation) {
    if (leftEncoder.getDistance() < 5000) {
      drive.arcadeDrive(speed, rotation);
    } else {
      drive.arcadeDrive(0, 0);
    }
  }

  

  public void resetEncoders() {
    leftEncoder.setDistancePerPulse(Constants.EncoderConstants.kDriveEncoderDPP);
    rightEncoder.setDistancePerPulse(Constants.EncoderConstants.kDriveEncoderDPP);
    leftEncoder.reset();
    rightEncoder.reset();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}