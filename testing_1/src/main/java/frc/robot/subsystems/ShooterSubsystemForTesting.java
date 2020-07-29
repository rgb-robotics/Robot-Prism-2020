/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;

public class ShooterSubsystemForTesting extends SubsystemBase {

  private final TalonSRX m_shooterLeftMotor;
  private final TalonSRX m_shooterRightMotor;
  private final Encoder m_shooterEncoder;

  public ShooterSubsystemForTesting() {
    m_shooterLeftMotor = new TalonSRX(7/*1*/);
    m_shooterRightMotor = new TalonSRX(8/*2*/);

    m_shooterEncoder = new Encoder(Constants.EncoderPorts.kShooterEncoderA, Constants.EncoderPorts.kShooterEncoderB, false, EncodingType.k4X);
  
    //TODO set below
    /*m_shooterEncoder.setDistancePerPulse();*/
  }

  @Override
  public void periodic() {
    m_shooterLeftMotor.set(TalonSRXControlMode.PercentOutput, 0.85);
    m_shooterRightMotor.set(TalonSRXControlMode.PercentOutput, -0.85);

    System.out.println(m_shooterEncoder.getRate());
    //TODO ^ -> highest printed value is setpoint, goal and maxVelocity.
  }
}
