/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

import frc.robot.subsystems.*;
import frc.robot.util.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot 
{
    // SUBSYSTEMS
    //public static MechanumDriveBase mechanumDriveBase;
    public static Level_1 level_1;

    public static PowerDistributionPanel pdp;
    public static OI oi;
  
    Command m_autonomousCommand;
    SendableChooser<Command> m_chooser = new SendableChooser<>();
  
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() 
    {
        //SUBSYSTEMS INIT
        //mechanumDriveBase = new MechanumDriveBase();
        

        pdp = new PowerDistributionPanel();
        oi = new OI();


        //AUTO CHOOSER
        //m_chooser.setDefaultOption("Default Auto", new HolonomicDriveCommand(swerveDriveBase));
        //SmartDashboard.putData("Auto mode", m_chooser);
    }
  
    /**
     * This function is called every robot packet, no matter the mode. Use
     * this for items like diagnostics that you want ran during disabled,
     * autonomous, teleoperated and test.
     *
     * <p>This runs after the mode specific periodic functions, but before
     * LiveWindow and SmartDashboard integrated updating.
     */
    @Override
    public void robotPeriodic() 
    {
        // PowerDistributionPanel pdp = new PowerDistributionPanel();
        // SmartDashboard.putNumber("Lifter/CurrentL", pdp.getCurrent(?));
        // SmartDashboard.putNumber("Lifter/CurrentR", pdp.getCurrent(?));
        // SmartDashboard.putNumber("Lifter/CurrentB", pdp.getCurrent(?));
    }
  
    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    @Override
    public void disabledInit() 
    {
        System.out.printf("Disabled Init");
    }
  
    /**
     * This function is called periodically during Disabled mode
     */
    @Override
    public void disabledPeriodic()
    {
        Scheduler.getInstance().run();
    }
  
    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString code to get the auto name from the text box below the Gyro
     *
     * <p>You can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons
     * to the switch structure below with additional strings & commands.
     */
    @Override
    public void autonomousInit() 
    {
        m_autonomousCommand = m_chooser.getSelected();
    
        /*
         * String autoSelected = SmartDashboard.getString("Auto Selector",
         * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
         * = new MyAutoCommand(); break; case "Default Auto": default:
         * autonomousCommand = new ExampleCommand(); break; }
         */
    
        // schedule the autonomous command (example)
        if (m_autonomousCommand != null) 
        {
            m_autonomousCommand.start();
        }
    }
  
    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic()
    {
        Scheduler.getInstance().run();
    }
  
    @Override
    public void teleopInit() 
    {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (m_autonomousCommand != null) 
        {
            m_autonomousCommand.cancel();
        }
    }
  
    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() 
    {
        Scheduler.getInstance().run();
    }

    CANSparkMax sparkTest;
    CANPIDController sparkPID;
    CANEncoder sparkTestEncoder;

    /**
     * This function is called once each time the robot enters test mode
     */
    @Override
    public void testInit() 
    {
        sparkTest = new CANSparkMax(13, MotorType.kBrushless);

        //sparkTest.restoreFactoryDefaults();

        sparkTestEncoder = sparkTest.getEncoder();

        sparkTest.setMotorType(MotorType.kBrushless);

        sparkPID = sparkTest.getPIDController();

        //sparkPID.setReference(0, ControlType.kPosition);
        //set PID values TODO : Tune These Values
        sparkPID.setP(2);
        sparkPID.setI(0);
        sparkPID.setD(0);

        //SmartDashboard.putNumber("Testing SPEED", 0.5);
    }
  
    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() 
    {
        //sparkTest.set(SmartDashboard.getNumber("Testing SPEED", 0.0));
        sparkTest.set(100);

        //sparkPID.setReference(10, ControlType.kPosition);

        System.out.println(sparkTest.get() + " | " + sparkTestEncoder.getPosition());
    }
}
