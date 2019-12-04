/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.GrabbingBall;
import edu.wpi.first.wpilibj.Spark;



/**
 * Add your docs here.
 */

public class BallGrabber extends Subsystem {

public Spark GrabbingRight = new Spark(RobotMap.GrabbingInPort);
public Spark GrabbingLeft = new Spark(RobotMap.GrabbingOutPort);
//public SpeedControllerGroup Grabbers = new SpeedControllerGroup(GrabbingIn, GrabbingOut);

public void GrabberInPower(double GrabbingR, double GrabbingL){
    GrabbingRight.set(GrabbingR - GrabbingL);
}

public void GrabberOutPower(double GrabbingR, double GrabbingL){
  GrabbingLeft.set(-(GrabbingR - GrabbingL));
}



  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new GrabbingBall());
  }
}
