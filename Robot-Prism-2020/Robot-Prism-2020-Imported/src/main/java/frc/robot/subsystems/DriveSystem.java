/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.RobotMap;
import frc.robot.commands.TeleopDrive;


/**
 * Add your docs here.
 */
public class DriveSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private Spark LeftFrontMotor = new Spark(RobotMap.LeftFrontPort);
  private Spark LeftBackMotor = new Spark(RobotMap.LeftBackPort);
  private Spark RightFrontMotor = new Spark(RobotMap.RightFrontPort);
  private Spark RightBackMotor = new Spark(RobotMap.RightBackPort);
  private SpeedControllerGroup LeftMotors = new SpeedControllerGroup(LeftFrontMotor, LeftBackMotor);
  private SpeedControllerGroup RightMotors = new SpeedControllerGroup(RightFrontMotor, RightBackMotor);
  private DifferentialDrive drive = new DifferentialDrive(LeftMotors, RightMotors);

  public void teleopDrive(double move, double turn) {
    //If you want to change the limit of the speed of the drive base
    //Just change the value of these
    //0.5 means 50% 1 means 100% of top speed, 0.7 means 70%
    if(move > 0.8 ){
      move = 0.8;
    }
    

    if(turn > 0.7 ){
      turn = 0.7;
    }

    if(turn < -0.7){
      turn = -0.7;
    }

    if(move < -0.8){
         move = -0.8;
    }

    
    
    drive.arcadeDrive(move, turn);
  } 

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new TeleopDrive());
  }
}
