/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.RotatorCommand;
import edu.wpi.first.wpilibj.Spark;

/**
 * Add your docs here.
 */
public class Rotator extends Subsystem {

  public Spark RotatingUpwards= new Spark(RobotMap.RotatorUp);
  public Spark RotatingDownwards = new Spark(RobotMap.RotatorDown);

  public void RotatingUpwardsPower(double RotatingPower){
    if(RotatingPower < 0){
      RotatingPower = 0;
    }
    RotatingUpwards.set(RotatingPower);
  }

  public void RotatingDownwardsPower(double RotatingPower2){
    if(RotatingPower2 > 0){
      RotatingPower2 = 0;
    }
    RotatingDownwards.set(RotatingPower2);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new RotatorCommand());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
