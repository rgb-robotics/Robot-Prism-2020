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

public class FeederSubsystem extends SubsystemBase {

  private final Spark m_feederLeftMotor = new Spark(Constants.FeederMotorPorts.kFeederLeftMotor);
  private final Spark m_feederRightMotor = new Spark(Constants.FeederMotorPorts.kFeederRightMotor);
  private final SpeedControllerGroup m_feederMotors = new SpeedControllerGroup(m_feederLeftMotor, m_feederRightMotor);

  private final DoubleSolenoid m_feederStopperSolenoid = new DoubleSolenoid(2, 3);

  public FeederSubsystem() {
    m_feederStopperSolenoid.set(DoubleSolenoid.Value.kForward);
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
  }
  public void feederStopperDown() {
    m_feederStopperSolenoid.set(DoubleSolenoid.Value.kReverse);
  }
  
  @Override
  public void periodic() {
  }
}
