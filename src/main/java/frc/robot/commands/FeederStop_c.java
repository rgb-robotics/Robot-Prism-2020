/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.GenericHID;
/*import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.OI;
import frc.robot.Robot;*/

/**
 * Add your docs here.
 */
public class FeederStop_c extends InstantCommand {
  /**
   * Add your docs here.
   */
  public FeederStop_c() {
    requires(Robot.fStop);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  } 
  // Called once when the command executes
  @Override
  public void execute() {
    final boolean StopperUp = Robot.oi.Controller.getBumper(GenericHID.Hand.kLeft);
    boolean StopperDown;
    if(Robot.oi.Controller.getTriggerAxis(GenericHID.Hand.kLeft)>0.2){
      StopperDown = true;
    }
    else{
      StopperDown = false;
    }
    Robot.fStop.Stop(StopperUp, StopperDown);
    
    /*final boolean Stopper1 = Robot.oi.Controller.getXButton();
    final boolean Stopper2 = Robot.oi.Controller.getYButton();
    Robot.fStop.Stop(Stopper1, Stopper2);*/
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
