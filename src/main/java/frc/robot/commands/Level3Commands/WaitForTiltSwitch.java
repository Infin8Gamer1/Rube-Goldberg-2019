/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Level3Commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.util.StopWatch;

public class WaitForTiltSwitch extends Command {
  private StopWatch timer;

  private boolean isDone = false;
  private boolean timerStarted = false;

  public WaitForTiltSwitch() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.level_3);

    timer = new StopWatch(750);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    SmartDashboard.putNumber("Stage", 2);

    //timer.reset();

    isDone = false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(!isDone)
    {
      if (Robot.level_3.getTiltSwitch() && !timerStarted)
      {
        timerStarted = true;
        timer.reset();
      }

      if (timerStarted){
        if (!Robot.level_3.getTiltSwitch()){
          timerStarted = false;
        } else if (timer.isExpired()){
          isDone = true;
        }
      }
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isDone; //&& timer.isExpired();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
