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
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;;

public class IntakeSubsystem extends SubsystemBase {

  private static final Spark m_intakeMotor = new Spark(Constants.IntakeMotorPorts.kIntakeMotor);
  private static final DoubleSolenoid m_intakeSolenoid = new DoubleSolenoid(Constants.SolenoidPorts.kIntakeSolenoidForwardChannel, Constants.SolenoidPorts.kIntakeSolenoidReverseChannel);

  public void intakeRun() {
    m_intakeMotor.set(0.8);
  }
  public void intakeStop() {
    m_intakeMotor.set(0);
  }

  public void intakeUp() {
    m_intakeSolenoid.set(Value.kReverse);
  }
  public void intakeDown() {
    m_intakeSolenoid.set(Value.kForward);
  }


  /*
  public void intake(boolean intakeStat) {
    if (intakeStat = true) {
      m_intakeMotor.set(0.8);
    } 
    else {
      m_intakeMotor.set(0);
    }
  }

  public void intakeElevation(boolean intakeElevationStat) {
    if (intakeElevationStat = true) {
      m_intakeSolenoid.set(Value.kReverse);
    }
    else {
      m_intakeSolenoid.set(Value.kForward);
    }
  }

  
  */

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}