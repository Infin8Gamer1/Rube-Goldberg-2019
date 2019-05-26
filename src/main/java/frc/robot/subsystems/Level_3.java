/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Servo;

/**
 * Add your docs here.
 */
public class Level_3 extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private final DigitalInput TiltSwitch;
  private final SerialPort ArduinoSerialPort;
  private final Servo CarKnocker;
  

  public Level_3() {
    TiltSwitch = new DigitalInput(2);

    ArduinoSerialPort = new SerialPort(9600, SerialPort.Port.kUSB);

    CarKnocker = new Servo(1);
  }

  public void TurnLightsOn() {
    ArduinoSerialPort.writeString("On\n");
  }

  public void TurnLightsOff() {
    ArduinoSerialPort.writeString("Off\n");
  }

  public void sendStringToArduino(String message){
    ArduinoSerialPort.writeString(message);
  }

  public boolean getTiltSwitch() {
    return TiltSwitch.get();
  }

  public void FlipCar() {
    CarKnocker.set(0.15);
  }

  public void UnFlipCar() {
    CarKnocker.set(0.29);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
