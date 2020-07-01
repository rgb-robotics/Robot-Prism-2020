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

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;

public class ShooterSubsystem extends PIDSubsystem {

  private final TalonSRX m_shooterLeftMotor;
  private final TalonSRX m_shooterRightMotor;
  private final Encoder m_shooterEncoder;

  public ShooterSubsystem() {
    super (new PIDController(Constants.PIDConstants.ShooterSubsystem.kP, Constants.PIDConstants.ShooterSubsystem.kI, Constants.PIDConstants.ShooterSubsystem.kD));
    
    m_shooterLeftMotor = new TalonSRX(7/*1*/);
    m_shooterRightMotor = new TalonSRX(8/*2*/);

    m_shooterEncoder = new Encoder(Constants.EncoderPorts.kShooterEncoderA, Constants.EncoderPorts.kShooterEncoderB, false, EncodingType.k4X);
    
    //TODO set below
    /*m_shooterEncoder.setDistancePerPulse();*/

    setSetpoint(0);
  }

  @Override
  protected void useOutput(double output, double setpoint) {
    m_shooterLeftMotor.set(TalonSRXControlMode.PercentOutput, output);
    m_shooterRightMotor.set(TalonSRXControlMode.PercentOutput, output);
  }

  @Override
  protected double getMeasurement() {
    return m_shooterEncoder.getRate();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
