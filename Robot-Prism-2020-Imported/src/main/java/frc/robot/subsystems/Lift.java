/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.LiftingLift;
import edu.wpi.first.wpilibj.Spark;


/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
 
public Spark Lift= new Spark(RobotMap.LiftPort);

public void LiftUpPower(double LiftPower){
 
Lift.set(LiftPower);

}

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new LiftingLift());

  }
}
