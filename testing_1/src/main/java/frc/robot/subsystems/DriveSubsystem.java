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
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;


public class DriveSubsystem extends SubsystemBase {

  private final Spark m_driveLeftMotor1;
  private final Spark m_driveLeftMotor2;
  private final Spark m_driveLeftMotor3;
  private final Spark m_driveRightMotor1;
  private final Spark m_driveRightMotor2;
  private final Spark m_driveRightMotor3;
  private final SpeedControllerGroup m_driveLeftMotors;
  private final SpeedControllerGroup m_driveRightMotors;
  private final DifferentialDrive m_drive;
  private final Encoder m_driveLeftEncoder;
  private final Encoder m_driveRightEncoder;

  public DriveSubsystem() {
    m_driveLeftMotor1 = new Spark(Constants.DriveMotorPorts.kDriveLeftMotor1);
    m_driveLeftMotor2 = new Spark(Constants.DriveMotorPorts.kDriveLeftMotor2);
    m_driveLeftMotor3 = new Spark(Constants.DriveMotorPorts.kDriveLeftMotor3);
    m_driveRightMotor1 = new Spark(Constants.DriveMotorPorts.kDriveRightMotor1);
    m_driveRightMotor2 = new Spark(Constants.DriveMotorPorts.kDriveRightMotor2);
    m_driveRightMotor3 = new Spark(Constants.DriveMotorPorts.kDriveRightMotor3);
    m_driveLeftMotors = new SpeedControllerGroup(m_driveLeftMotor1, m_driveLeftMotor2, m_driveLeftMotor3);
    m_driveRightMotors = new SpeedControllerGroup(m_driveRightMotor1, m_driveRightMotor2, m_driveRightMotor3);
    m_drive = new DifferentialDrive(m_driveLeftMotors, m_driveRightMotors);
    m_driveLeftEncoder = new Encoder(Constants.EncoderPorts.kDriveLeftEncoderA, Constants.EncoderPorts.kDriveLeftEncoderB, false, EncodingType.k4X);
    m_driveRightEncoder = new Encoder(Constants.EncoderPorts.kDriveRightEncoderA, Constants.EncoderPorts.kDriveRightEncoderB, true, EncodingType.k4X);

    m_driveLeftEncoder.setDistancePerPulse(Constants.EncoderConstants.DriveEncoderConstants.kDriveEncoderDPP);
    m_driveRightEncoder.setDistancePerPulse(Constants.EncoderConstants.DriveEncoderConstants.kDriveEncoderDPP);
  }

  public void drive(double speed, double rotation, double throttle) {
    double scale = (throttle * -0.125) + 0.675;
    
    m_drive.arcadeDrive(speed * scale, rotation * scale);
  }

  public double getDistanceDriven() {
    double distanceDriven = m_driveLeftEncoder.getDistance();
    //double distanceDriven = (m_driveLeftEncoder.getDistance() + m_driveRightEncoder.getDistance()) / 2;

    return distanceDriven;
  }

  public void resetEncoders() {
    m_driveLeftEncoder.reset();
    m_driveRightEncoder.reset();
  }

  @Override
  public void periodic() {
  }
}