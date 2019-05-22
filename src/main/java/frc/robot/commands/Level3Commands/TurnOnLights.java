/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Level3Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.util.StopWatch;

public class TurnOnLights extends Command {
  private StopWatch timer;
  
  public TurnOnLights() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.level_3);

    timer = new StopWatch(7500);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.level_3.TurnLightsOn();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return timer.isExpired();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.level_3.TurnLightsOff();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
