/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.GenericHID;



public class Feeder_c extends Command {
  public Feeder_c() {
    // Use requires() here to declare subsystem dependencies
  requires(Robot.Feeder);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

	  final boolean IntakeUp = Robot.oi.Controller.getBumper(GenericHID.Hand.kRight);
    boolean IntakeDown;
    if(Robot.oi.Controller.getTriggerAxis(GenericHID.Hand.kRight)>0.2){
      IntakeDown = true;
    }
    else{
      IntakeDown = false;
    }
    Robot.arm.Intake_v(IntakeUp, IntakeDown);
    final boolean StopperDown = Robot.oi.Controller.getBumper(GenericHID.Hand.kLeft);
    boolean StopperUp;
    if(Robot.oi.Controller.getTriggerAxis(GenericHID.Hand.kLeft)>0.2){
      StopperUp = true;
    }
    else{
      StopperUp = false;
    }
    Robot.arm.Stop(StopperUp, StopperDown);
    
    
    final boolean IntakeGo = Robot.oi.Controller.getAButton();
    Robot.arm.Intake_g(IntakeGo);
    final boolean feederUp = Robot.oi.stick.getRawButton(4);
    final boolean feederDown = Robot.oi.stick.getRawButton(3);

    Robot.Feeder.feeder_v(feederUp, feederDown);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
