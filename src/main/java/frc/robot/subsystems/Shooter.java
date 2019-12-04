/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Shooter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  DoubleSolenoid pitchSolenoid1 = null;
  DoubleSolenoid pitchSolenoid2 = null;

  public Shooter() {
    pitchSolenoid1 = new DoubleSolenoid(RobotMap.SHOOTER_PITCH_SOLENOID1_DEPLOY, RobotMap.SHOOTER_PITCH_SOLENOID1_RETRACT);
    pitchSolenoid2 = new DoubleSolenoid(RobotMap.SHOOTER_PITCH_SOLENOID2_DEPLOY, RobotMap.SHOOTER_PITCH_SOLENOID2_RETRACT);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void pitchUp() {
    pitchSolenoid1.set(Value.kForward);
    pitchSolenoid2.set(Value.kForward);
  }
  
  public void pitchDown() {
    pitchSolenoid1.set(Value.kReverse);
    pitchSolenoid2.set(Value.kReverse);
  }
}
