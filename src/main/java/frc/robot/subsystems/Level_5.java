/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.util.PIDexecutor;

/**
 * Add your docs here.
 */
public class Level_5 extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public final WPI_TalonSRX FlagRaiseMotor;
  private final DigitalInput MagnetSensor;

  private static PIDexecutor FlagPID;

  public Level_5() {
    FlagRaiseMotor = new WPI_TalonSRX(3);

    MagnetSensor = new DigitalInput(1);

    //                         KP   KI  KD                Starting Position
    FlagPID = new PIDexecutor(0.2, 0.0, 0.01, FlagRaiseMotor.getSelectedSensorPosition(0), new DoubleSupplier()
    {
        @Override
        public double getAsDouble()
        {
            return FlagRaiseMotor.getSelectedSensorPosition(0);
        }
    });
  }

  public int getFlagCurrentPosition() {
    return FlagRaiseMotor.getSelectedSensorPosition(0);
  }

  public void SetFlagTarget(int Target){
    FlagPID.setTarget(Target);
  }

  public boolean GetMagnetSensor() {
    return MagnetSensor.get();
  }

  @Override
  public void periodic() {
    super.periodic();

    FlagRaiseMotor.set(FlagPID.run());
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
