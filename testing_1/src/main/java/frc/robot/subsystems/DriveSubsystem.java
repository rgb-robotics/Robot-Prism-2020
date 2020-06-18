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

  private final SpeedControllerGroup m_leftMotors;
  private final SpeedControllerGroup m_rightMotors;
  private final DifferentialDrive m_drive;
  private final Encoder m_leftEncoder;
  private final Encoder m_rightEncoder;

  public DriveSubsystem() {
    m_leftMotors = new SpeedControllerGroup(new Spark(Constants.DriveMotorPorts.kLeftMotor1), new Spark(Constants.DriveMotorPorts.kLeftMotor2), new Spark(Constants.DriveMotorPorts.kLeftMotor3));
    m_rightMotors = new SpeedControllerGroup(new Spark(Constants.DriveMotorPorts.kRightMotor1), new Spark(Constants.DriveMotorPorts.kRightMotor2), new Spark(Constants.DriveMotorPorts.kRightMotor3));
    m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);
    m_leftEncoder = new Encoder(Constants.EncoderPorts.kDriveLeftEncoderA, Constants.EncoderPorts.kDriveLeftEncoderB, false, EncodingType.k4X);
    m_rightEncoder = new Encoder(Constants.EncoderPorts.kDriveRightEncoderA, Constants.EncoderPorts.kDriveRightEncoderB, true, EncodingType.k4X);
  }

  public void drive(double speed, double rotation, double scale) {
    if (m_leftEncoder.getDistance() < 5000) {
      m_drive.arcadeDrive(speed * scale, rotation * scale);
    } else {
      m_drive.arcadeDrive(0, 0);
    }
  }

  public void resetEncoders() {
    m_leftEncoder.setDistancePerPulse(Constants.EncoderConstants.kDriveEncoderDPP);
    m_rightEncoder.setDistancePerPulse(Constants.EncoderConstants.kDriveEncoderDPP);
    m_leftEncoder.reset();
    m_rightEncoder.reset();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}