/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;

public class DriveSubsystem_FF extends SubsystemBase {

  private final SimpleMotorFeedforward m_FFController = new SimpleMotorFeedforward(Constants.FeedforwardConstants.DriveSubsystem.kS, Constants.FeedforwardConstants.DriveSubsystem.kV, Constants.FeedforwardConstants.DriveSubsystem.kA);

  private final Spark m_driveLeftMotor1 = new Spark(Constants.DriveMotorPorts.kDriveLeftMotor1);
  private final Spark m_driveLeftMotor2 = new Spark(Constants.DriveMotorPorts.kDriveLeftMotor2);
  private final Spark m_driveLeftMotor3 = new Spark(Constants.DriveMotorPorts.kDriveLeftMotor3);
  private final Spark m_driveRightMotor1 = new Spark(Constants.DriveMotorPorts.kDriveRightMotor1);
  private final Spark m_driveRightMotor2 = new Spark(Constants.DriveMotorPorts.kDriveRightMotor2);
  private final Spark m_driveRightMotor3 = new Spark(Constants.DriveMotorPorts.kDriveRightMotor3);

  private final SpeedControllerGroup m_driveLeftMotors = new SpeedControllerGroup(m_driveLeftMotor1, m_driveLeftMotor2, m_driveLeftMotor3);
  private final SpeedControllerGroup m_driveRightMotors = new SpeedControllerGroup(m_driveRightMotor1, m_driveRightMotor2, m_driveRightMotor3);
  private final DifferentialDrive m_drive = new DifferentialDrive(m_driveLeftMotors, m_driveRightMotors);

  private final Encoder m_driveLeftEncoder = new Encoder(Constants.EncoderPorts.kDriveLeftEncoderA, Constants.EncoderPorts.kDriveLeftEncoderB, false, EncodingType.k4X);
  private final Encoder m_driveRightEncoder = new Encoder(Constants.EncoderPorts.kDriveRightEncoderA, Constants.EncoderPorts.kDriveRightEncoderB, true, EncodingType.k4X);

  public DriveSubsystem_FF() {
    m_driveLeftEncoder.setDistancePerPulse(Constants.EncoderConstants.DriveEncoderConstants.kDriveEncoderDPP);
    m_driveRightEncoder.setDistancePerPulse(Constants.EncoderConstants.DriveEncoderConstants.kDriveEncoderDPP);
  }

  public void arcadeDrive(double speed, double rotation, double throttle) {
    double scale = (throttle * -0.125) + 0.675;
    
    m_drive.arcadeDrive(speed * scale, rotation * scale);
  }

  public void voltageDrive(double leftVoltage, double rightVoltage) {
    m_driveLeftMotors.setVoltage(leftVoltage);
    m_driveRightMotors.setVoltage(rightVoltage);
  }

  public double FFOutput(TrapezoidProfile.State setpoint) {
    return m_FFController.calculate(setpoint.velocity, 0);
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