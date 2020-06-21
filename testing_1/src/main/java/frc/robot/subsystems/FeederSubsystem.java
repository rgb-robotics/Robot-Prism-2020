/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class FeederSubsystem extends SubsystemBase {

  private final Spark m_feederLeftMotor;
  private final Spark m_feederRightMotor;
  private final SpeedControllerGroup m_feederMotors;

  private final DoubleSolenoid m_feederStopperSolenoid;

  private static boolean m_feederStopperStat;

  public FeederSubsystem() {
    m_feederLeftMotor = new Spark(Constants.FeederMotorPorts.kFeederLeftMotor);
    m_feederRightMotor = new Spark(Constants.FeederMotorPorts.kFeederRightMotor);
    m_feederMotors = new SpeedControllerGroup(m_feederLeftMotor, m_feederRightMotor);

    m_feederStopperSolenoid = new DoubleSolenoid(2, 3);

    m_feederStopperStat = false;
  }

  public void feederUp() {
    m_feederMotors.set(0.4);
  }
  public void feederDown() {
    m_feederMotors.set(-0.4);
  }
  public void feederStop() {
    m_feederMotors.stopMotor();
  }

  public void feederStopperUp() {
    m_feederStopperSolenoid.set(DoubleSolenoid.Value.kForward);
    m_feederStopperStat = true;
  }
  public void feederStopperDown() {
    m_feederStopperSolenoid.set(DoubleSolenoid.Value.kReverse);
    m_feederStopperStat = false;
  }
  public void feederStopperUpDown() {
    m_feederStopperStat = !m_feederStopperStat;

    if (m_feederStopperStat) {
      feederStopperUp();
    }
    else {
      feederStopperDown();
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
