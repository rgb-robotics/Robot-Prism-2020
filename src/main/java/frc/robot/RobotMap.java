/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;a
  // public static int rightMotor = 2;

  public static final int SHOOTER_PITCH_SOLENOID1_DEPLOY = 2;
  public static final int SHOOTER_PITCH_SOLENOID1_RETRACT = 3;

  public static final int SHOOTER_PITCH_SOLENOID2_DEPLOY = 4;
  public static final int SHOOTER_PITCH_SOLENOID2_RETRACT = 5;

  public static int LeftFrontPort = 0;
  public static int LeftBackPort = 1;
  public static int RightFrontPort = 2;
  public static int RightBackPort = 3;

//lift
  public static int LiftPort = 4;

//BallGrabber
  public static int GrabbingInPort = 5;
  public static int GrabbingOutPort = 6;

//Rotator
  public static int RotatorUp = 7;
  public static int RotatorDown = 8;


//Disc linear actuator
  public static int DiscPort = 9;

/*
public static int DiscPort = 8;
public static int RotatorDown = 9;
*/

  public static int JoystickPort = 0;

  public static int XboxControllerPort = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}