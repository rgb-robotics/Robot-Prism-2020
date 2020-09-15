/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;

public class ShooterSubsystem extends PIDSubsystem {

  private final SimpleMotorFeedforward m_FFController = new SimpleMotorFeedforward(Constants.FeedforwardConstants.ShooterSubsystem.kS, Constants.FeedforwardConstants.ShooterSubsystem.kV, Constants.FeedforwardConstants.ShooterSubsystem.kA);

  private final WPI_TalonSRX m_shooterLeftMotor = new WPI_TalonSRX(7/*1*/);
  private final WPI_TalonSRX m_shooterRightMotor = new WPI_TalonSRX(8/*2*/);

  private final Encoder m_shooterEncoder = new Encoder(Constants.EncoderPorts.kShooterEncoderA, Constants.EncoderPorts.kShooterEncoderB, false, EncodingType.k4X);

  public ShooterSubsystem() {
    super (new PIDController(Constants.PIDConstants.ShooterSubsystem.kP, Constants.PIDConstants.ShooterSubsystem.kI, Constants.PIDConstants.ShooterSubsystem.kD));

    m_shooterEncoder.setDistancePerPulse/*revolutionPerPulse*/(Constants.EncoderConstants.ShooterEncoderConstants.kShooterEncoderRPP);

    setSetpoint(0);
  }

  @Override
  protected void useOutput(double PIDOutput, double setpoint) {
    m_shooterLeftMotor.setVoltage(FFOutput() + PIDOutput);
    m_shooterRightMotor.setVoltage(-FFOutput() - PIDOutput);
  }

  @Override
  protected double getMeasurement() {
    return m_shooterEncoder.getRate();
  }

  public double FFOutput() {
    return m_FFController.calculate(/*velocity*/0, /*acceleration*/0);
  }

  @Override
  public void periodic() {
  }
}
