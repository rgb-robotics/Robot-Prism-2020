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
import edu.wpi.first.wpilibj.Spark;


/**
 * Add your docs here.
 */
public class FeederArm extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  DoubleSolenoid ArmSolenoid = null;
  public Spark IntakeMotor = new Spark(RobotMap.IntakePort);
  public FeederArm() {
    ArmSolenoid = new DoubleSolenoid(RobotMap.ArmSolenoidPush, RobotMap.ArmSolenoidPull);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void Intake_v(boolean IntakeUp, boolean IntakeDown){
    if(IntakeUp == true && IntakeDown == false){
      ArmSolenoid.set(Value.kReverse);      }
    else if(IntakeUp == false && IntakeDown == true){
      ArmSolenoid.set(Value.kForward);
    }
    else{
    }

  
}
  public void Intake_g(boolean IntakeGo){
    if(IntakeGo == true){
    IntakeMotor.set(0.8); 
    }
    else{
      IntakeMotor.set(0);
    }
}  
}
