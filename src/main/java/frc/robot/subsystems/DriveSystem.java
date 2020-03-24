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
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import frc.robot.RobotMap;
import frc.robot.commands.TeleopDrive;


import edu.wpi.first.wpilibj.Encoder;

/**
 * Add your docs here.
 */
public class DriveSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  

  private Spark RightAMotor = new Spark(RobotMap.RightAPort);
  private Spark RightBMotor = new Spark(RobotMap.RightBPort);
  private Spark RightCMotor = new Spark(RobotMap.RightCPort);
  private Spark LeftAMotor = new Spark(RobotMap.LeftAPort);
  private Spark LeftBMotor = new Spark(RobotMap.LeftBPort);
  private Spark LeftCMotor = new Spark(RobotMap.LeftCPort);
  private SpeedControllerGroup LeftMotors = new SpeedControllerGroup(LeftAMotor, LeftBMotor, LeftCMotor);
  private SpeedControllerGroup RightMotors = new SpeedControllerGroup(RightAMotor, RightBMotor, RightCMotor);
  private DifferentialDrive drive = new DifferentialDrive(LeftMotors, RightMotors);
 
  private Encoder leftEncoder = new Encoder(1, 2, false, EncodingType.k4X);
  public static final double kDistancePerPulse = 18.84/1024;

  public void teleopDrive(double move, double turn, double scale) {
    
    //If you want to change the limit of the speed of the drive base
    //Just change the value of these
    //0.5 means 50% 1 means 100% of top speed, 0.7 means 70%
    /*
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
    */

  double move2 = move * scale;
  double turn2 = turn * scale;
    
    
    drive.arcadeDrive(move2, turn2);
  
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new TeleopDrive());
  }
  public void autonomous() {
    leftEncoder.setDistancePerPulse(kDistancePerPulse);
    leftEncoder.reset();
    if (leftEncoder.getDistance() < 50) {
      drive.arcadeDrive(0.5, 0);
    }else {
      drive.arcadeDrive(0, 0);
    }
  }
}
