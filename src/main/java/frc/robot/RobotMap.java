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


  public static final int FeederSolenoidToggle = 0;  
  public static final int ArmSolenoidPush = 1;
  public static final int ArmSolenoidPull = 2;

//motor ports

  public static int RightAPort = 1;
  public static int RightBPort = 2;
  public static int RightCPort = 3;  
  public static int LeftAPort = 4;
  public static int LeftBPort = 5;
  public static int LeftCPort = 6;  

//intake 
  public static int IntakePort = 0;

//feeder ports
  public static int FeederA = 7;
  public static int FeederB = 8;



  public static int JoystickPort = 0;

  public static int XboxControllerPort = 1;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}