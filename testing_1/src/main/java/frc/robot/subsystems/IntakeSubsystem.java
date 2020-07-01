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

  private final Spark m_intakeMotor;
  
  private final DoubleSolenoid m_intakeSolenoid;
  
  private static boolean m_intakeStat;//true=run, false=stop
  private static boolean m_intakeElevationStat; //true=down, false=up

  public IntakeSubsystem() {
    m_intakeMotor = new Spark(Constants.IntakeMotorPorts.kIntakeMotor);

    m_intakeSolenoid = new DoubleSolenoid(Constants.SolenoidPorts.kIntakeSolenoidForwardChannel, Constants.SolenoidPorts.kIntakeSolenoidReverseChannel);

    m_intakeStat = false;
    m_intakeElevationStat = false;
  }

  public void intakeRun() {
    m_intakeMotor.set(0.8);
  }
  public void intakeStop() {
    m_intakeMotor.set(0);
  }
  

  public void intakeDown() {
    m_intakeSolenoid.set(DoubleSolenoid.Value.kForward);
    m_intakeElevationStat = true;
  }
  public void intakeUp() {
    m_intakeSolenoid.set(DoubleSolenoid.Value.kReverse);
    m_intakeElevationStat = false;
  }
  public void intakeDownUp() {
    m_intakeElevationStat = !m_intakeElevationStat;

    if (m_intakeElevationStat) {
      intakeDown();
    } 
    else {
      intakeUp();
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}