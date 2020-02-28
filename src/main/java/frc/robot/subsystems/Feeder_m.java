/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Feeder_c;
import edu.wpi.first.wpilibj.Spark;



/**
 * Add your docs here.
 */

public class Feeder_m extends Subsystem {

public Spark FeederA = new Spark(RobotMap.FeederA);
public Spark FeederB = new Spark(RobotMap.FeederB);
//public SpeedControllerGroup Grabbers = new SpeedControllerGroup(GrabbingIn, GrabbingOut);

public void FeederInPower(double GrabbingR, double GrabbingL){
    FeederA.set(GrabbingR - GrabbingL);
}

public void FeederOutPower(double GrabbingR, double GrabbingL){
    FeederB.set(-(GrabbingR - GrabbingL));
}



  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Feeder_c());
  }
}
