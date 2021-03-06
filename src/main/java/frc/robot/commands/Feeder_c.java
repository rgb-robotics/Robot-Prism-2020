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
import edu.wpi.first.wpilibj.Timer;



public class Feeder_c extends Command {
  boolean StopperUp = false;
  boolean IntakeGo = true;
  double latest;
  double debounce_period = 0.6;
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
    double now = Timer.getFPGATimestamp();
	  final boolean IntakeUp = Robot.oi.Controller.getBumper(GenericHID.Hand.kRight);
    boolean IntakeDown;
    if(Robot.oi.Controller.getTriggerAxis(GenericHID.Hand.kRight)>0.2){
      IntakeDown = true;
    }
    else{
      IntakeDown = false;
    }
    Robot.arm.Intake_v(IntakeUp, IntakeDown);

    if (Robot.oi.stick.getRawButton(1)){
      if((now-latest) > debounce_period){
        latest = now;
        StopperUp = !StopperUp;
      Robot.arm.Stop(StopperUp);
    }
      ;
    };
    
    if (Robot.oi.Controller.getRawButtonPressed(1)){
      IntakeGo = !IntakeGo;
      Robot.arm.Intake_g(IntakeGo);
    }

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
