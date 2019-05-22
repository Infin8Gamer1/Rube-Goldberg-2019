/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Level_1 extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private final Servo GolfBallDroper;
  private final AnalogInput LightSensor;
  private final double LightVoltageThreshhold = 0.4f;

  public Level_1() {
    GolfBallDroper = new Servo(0);

    LightSensor = new AnalogInput(3);
  }

  public void DropBall(){
    GolfBallDroper.set(1.0);
  }

  public void HoldBall(){
    GolfBallDroper.set(0.5);
  }

  public boolean CheckLightSensor(){
    return (LightSensor.getVoltage() <= LightVoltageThreshhold);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
