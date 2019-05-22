/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.Level1Commands.*;
import frc.robot.commands.Level3Commands.*;
import frc.robot.commands.Level5Commands.*;
import frc.robot.Robot;

public class Auto extends CommandGroup {
  /**
   * Add your docs here.
   */
  public Auto() {
    requires(Robot.level_1);
    requires(Robot.level_3);
    requires(Robot.level_5);

    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    addSequential(new WaitForCar()); //Holds
    addSequential(new DropGolfBall());
    addSequential(new WaitForTiltSwitch()); //Holds
    addSequential(new TurnOnLights());
    addSequential(new PushCarOff());
    addSequential(new WaitForMagnet()); //Holds
    addSequential(new RaiseFlag());

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
  }
}
