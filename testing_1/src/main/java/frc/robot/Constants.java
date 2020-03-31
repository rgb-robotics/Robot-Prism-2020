/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    
  //drive motor PWM ports
  public static final int leftMotorA = 1;
  public static final int leftMotorB = 2;
  public static final int leftMotorC = 3;
  public static final int rightMotorA = 4;
  public static final int rightMotorB = 5;
  public static final int rightMotorC = 6;  

  //encoder DIO ports
  public static final int driveLeftEncoderA = 1;
  public static final int driveLeftEncoderB = 2;
  public static final int driveRightEncoderA = 3;
  public static final int driveRightEncoderB = 4;

  //controller ports
  public static final int stickPort = 0;
  public static final int controllerPort = 1;

  //encoder distance per pulse
  public static final int driveLeftEncoderDistancePerPulse = 1 / 256;
  public static final int driveRightEncoderDistancePerPulse = 1 / 256;
}
