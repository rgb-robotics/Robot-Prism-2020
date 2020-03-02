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
public class FeederStopper extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  DoubleSolenoid StopperSolenoid = null;
  public FeederStopper(){
    StopperSolenoid = new DoubleSolenoid(RobotMap.StopperSolenoidPush, RobotMap.StopperSolenoidPull);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void Stop(boolean StopperUp, boolean StopperDown) {
    if(StopperUp == true && StopperDown == false){
    StopperSolenoid.set(Value.kForward);
  }
  else if(StopperDown == true && StopperUp == false){
    StopperSolenoid.set(Value.kReverse);
  }
}
  
}
