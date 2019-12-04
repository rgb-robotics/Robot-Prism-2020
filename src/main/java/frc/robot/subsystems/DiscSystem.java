
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

 public class DiscSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
public Servo DiscServo = new Servo(RobotMap.DiscPort);


public void Disc(boolean Shoot){

if(Shoot){
  DiscServo.set(0);
}

else{
  DiscServo.set(0);
}

}
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
  }
}
