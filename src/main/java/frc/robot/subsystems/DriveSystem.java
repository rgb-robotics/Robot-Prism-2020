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

  

  private static Spark RightAMotor = new Spark(RobotMap.RightAPort);
  private static Spark RightBMotor = new Spark(RobotMap.RightBPort);
  private static Spark RightCMotor = new Spark(RobotMap.RightCPort);
  private static Spark LeftAMotor = new Spark(RobotMap.LeftAPort);
  private static Spark LeftBMotor = new Spark(RobotMap.LeftBPort);
  private static Spark LeftCMotor = new Spark(RobotMap.LeftCPort);
  private static SpeedControllerGroup LeftMotors = new SpeedControllerGroup(LeftAMotor, LeftBMotor, LeftCMotor);
  private static SpeedControllerGroup RightMotors = new SpeedControllerGroup(RightAMotor, RightBMotor, RightCMotor);
  private static DifferentialDrive drive = new DifferentialDrive(LeftMotors, RightMotors);

  private static Encoder leftEncoder = new Encoder(0, 1, false, EncodingType.k4X);

  public void teleopDrive(double move, double turn, double scale) {

    double move2 = move * scale;
    double turn2 = turn * scale;

    /*System.out.println(leftEncoder.getDistance());

    if (leftEncoder.getDistance() < 50) {
      move2 = 0.5;
    } else {
      move2 = 0;
    }*/
    drive.arcadeDrive(move2, turn2);

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new TeleopDrive());

    leftEncoder.setDistancePerPulse(1 / 256);
    //leftEncoder.reset();
  }

  public static void autonomous() {
    System.out.println(leftEncoder.getDistance());
    if (leftEncoder.getDistance() < 200) {
      drive.arcadeDrive(0.5, 0);
    }else {
      drive.arcadeDrive(0, 0);
      System.out.println("off");
    }
  }
}
