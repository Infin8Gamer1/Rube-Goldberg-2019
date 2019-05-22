/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Level5Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.util.StopWatch;

public class RaiseFlag extends Command {
  private StopWatch timer;

  public RaiseFlag() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.level_5);

    timer = new StopWatch(5000);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.level_5.FlagRaiseMotor.set(1.0);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return timer.isExpired();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.level_5.FlagRaiseMotor.set(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
