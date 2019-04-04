// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4579.Robot2019;

import org.usfirst.frc4579.Robot2019.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc4579.Robot2019.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton invertControls_Button;
    public Joystick driveStick;
    public JoystickButton holdHatch_button;
    public JoystickButton intakeBall_Button;
    public JoystickButton ejectBall_Button;
    public JoystickButton ballLiftMode_Button;
    public JoystickButton hatchLiftMode_Button;
    public JoystickButton tiltIntakeDown_Button;
    public JoystickButton tiltIntakeUp_Button;
    public JoystickButton changeInterval_Button;
    public JoystickButton resetBallIntervals_Button;
    public JoystickButton resetHatchIntervals_Button;
    public Joystick everyStick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        everyStick = new Joystick(1);
        
        resetHatchIntervals_Button = new JoystickButton(everyStick, 3);
        resetHatchIntervals_Button.whenPressed(new resetHatchIntervals());
        resetBallIntervals_Button = new JoystickButton(everyStick, 3);
        resetBallIntervals_Button.whenPressed(new resetBallIntervals());
        changeInterval_Button = new JoystickButton(everyStick, 4);
        changeInterval_Button.whenPressed(new changeInterval());
        tiltIntakeUp_Button = new JoystickButton(everyStick, 11);
        tiltIntakeUp_Button.whileHeld(new tiltIntakeUp());
        tiltIntakeDown_Button = new JoystickButton(everyStick, 10);
        tiltIntakeDown_Button.whileHeld(new tiltIntakeDown());
        hatchLiftMode_Button = new JoystickButton(everyStick, 5);
        hatchLiftMode_Button.whenPressed(new hatchLiftMode());
        ballLiftMode_Button = new JoystickButton(everyStick, 5);
        ballLiftMode_Button.whenPressed(new ballLiftMode());
        ejectBall_Button = new JoystickButton(everyStick, 9);
        ejectBall_Button.whileHeld(new ejectBall());
        intakeBall_Button = new JoystickButton(everyStick, 8);
        intakeBall_Button.whileHeld(new intakeBall());
        holdHatch_button = new JoystickButton(everyStick, 1);
        holdHatch_button.whenPressed(new holdHatch());
        driveStick = new Joystick(0);
        
        invertControls_Button = new JoystickButton(driveStick, 12);
        invertControls_Button.whenPressed(new invertControls());


        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("drive", new drive());
        SmartDashboard.putData("intakeBall", new intakeBall());
        SmartDashboard.putData("ejectBall", new ejectBall());
        SmartDashboard.putData("holdHatch", new holdHatch());
        SmartDashboard.putData("invertControls", new invertControls());
        SmartDashboard.putData("measure", new measure());
        SmartDashboard.putData("ballLiftMode", new ballLiftMode());
        SmartDashboard.putData("hatchLiftMode", new hatchLiftMode());
        SmartDashboard.putData("moveBallLifter", new moveBallLifter());
        SmartDashboard.putData("moveHatchLifter", new moveHatchLifter());
        SmartDashboard.putData("tiltIntakeUp", new tiltIntakeUp());
        SmartDashboard.putData("tiltIntakeDown", new tiltIntakeDown());
        SmartDashboard.putData("changeInterval", new changeInterval());
        SmartDashboard.putData("resetBallIntervals", new resetBallIntervals());
        SmartDashboard.putData("resetHatchIntervals", new resetHatchIntervals());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getdriveStick() {
        return driveStick;
    }

    public Joystick geteveryStick() {
        return everyStick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

