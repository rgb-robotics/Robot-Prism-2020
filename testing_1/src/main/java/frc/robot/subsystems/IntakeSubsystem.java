/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class IntakeSubsystem extends SubsystemBase {

  private final Spark m_intakeMotor = new Spark(Constants.IntakeMotorPorts.kIntakeMotor);
  
  private final DoubleSolenoid m_intakeSolenoid = new DoubleSolenoid(Constants.SolenoidPorts.kIntakeSolenoidForwardChannel, Constants.SolenoidPorts.kIntakeSolenoidReverseChannel);

  public IntakeSubsystem() {
    m_intakeSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  public void intakeRun() {
    m_intakeMotor.set(0.8);
  }
  public void intakeStop() {
    m_intakeMotor.set(0);
  }

  public void intakeDown() {
    m_intakeSolenoid.set(DoubleSolenoid.Value.kForward);
  }
  public void intakeUp() {
    m_intakeSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void periodic() {
  }
}