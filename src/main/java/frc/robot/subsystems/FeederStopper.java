/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


/**
 * Add your docs here.
 */
public class FeederStopper extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Solenoid StopperSolenoid = null;

  public FeederStopper(){
    StopperSolenoid = new Solenoid(RobotMap.FeederSolenoidToggle);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void Stop(boolean IntakeStopPiston) {
    if(IntakeStopPiston == true){
    StopperSolenoid.set(true);
  }
  else{
    StopperSolenoid.set(false);
  }
}
  
}
