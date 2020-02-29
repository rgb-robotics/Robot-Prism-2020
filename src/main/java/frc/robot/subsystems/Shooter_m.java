/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.Shooting_c;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;



/**
 * Add your docs here.
 */

public class Shooter_m extends Subsystem {

public TalonSRX ShooterA = new TalonSRX(7);
public TalonSRX ShooterB = new TalonSRX(8);
//public SpeedControllerGroup Grabbers = new SpeedControllerGroup(GrabbingIn, GrabbingOut);

public void shoot_v(boolean ShootYes){
  if(ShootYes == true){
    ShooterA.set(ControlMode.PercentOutput, 0.7);
    ShooterB.set(ControlMode.PercentOutput, -0.7);
  }
  else{
    ShooterA.set(ControlMode.PercentOutput, 0);
    ShooterB.set(ControlMode.PercentOutput, 0);
  }
}




  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Shooting_c());
  }
}
