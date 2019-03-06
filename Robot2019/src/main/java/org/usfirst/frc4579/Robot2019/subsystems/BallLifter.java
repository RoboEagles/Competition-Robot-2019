// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4579.Robot2019.subsystems;


import org.usfirst.frc4579.Robot2019.Robot;
import org.usfirst.frc4579.Robot2019.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.*;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class BallLifter extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private Encoder encoder;
    private Spark lifterMotor;
    private PIDController ballLifter_PID;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public BallLifter() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        encoder = new Encoder(5, 6, false, EncodingType.k4X);
        addChild("encoder",encoder);
        encoder.setDistancePerPulse(1.0);
        encoder.setPIDSourceType(PIDSourceType.kRate);
        
        lifterMotor = new Spark(3);
        addChild("lifterMotor",lifterMotor);
        lifterMotor.setInverted(false);
        
        ballLifter_PID = new PIDController(0.001, 0.0, 0.0, 0.0, encoder, lifterMotor, 0.02);
        addChild("ballLifter_PID",ballLifter_PID);
        ballLifter_PID.setContinuous(false);
        ballLifter_PID.setAbsoluteTolerance(0.2);

        ballLifter_PID.setOutputRange(-1.0, 1.0);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    boolean usingIntervals = false;        // Whether the robot is moving based on intervals or the joystick throttle
    int intervalGoal = 0;                 // The current height interval that the robot is aiming for
    int totalGoals = 3;                   // The number of intervals the robot can switch between

    final int pulsesPerRevolution = 7;                                        // The amount of pulses received after one full revolution of the motor.
    final double gearRatio = 188;                                             // The gear ratio for the lifter motor
    final double degreePerPulse = 360 / (gearRatio * pulsesPerRevolution);    // Finds how many degrees each pulse represents

    final double armHeight = 27.0;          // How hight up the pivot point of the arm is from the ground
    final double armLength = 17.0;          // The length of the arm

    // Main method for the subsystem that should be called by the command
    public void moveBallLifter(){
        if(usingIntervals){
            // ballLifter_PID.enable();

            // if(Robot.oi.everyStick.getRawButtonPressed(8)){
            //     // Moves up an interval
            //     intervalGoal = ++intervalGoal % totalGoals;
            //     System.out.println("Aiming for goal: " + intervalGoal);
            // }
            // // else if(Robot.oi.everyStick.getRawButtonPressed()){
            // //     // Moves down an interval
            // //     intervalGoal--;
            // //     if(intervalGoal < 0){
            // //         intervalGoal = totalGoals - 1;
            // //     }
            // // }

            // // Moves the ball lifter to its appropriate goal
            // switch (intervalGoal){
            //     case 0:
            //         moveToLoading();
            //         break;
            //     case 1:
            //         moveToFirst();
            //         break;
            //     case 2:
            //         moveToSecond();
            //         break;
            //     default:
            //         moveToLoading();
            // }
        }
        else{
            // ballLifter_PID.disable();
            moveManually();
        }
    }

    // Method for moving the lift to the height of the Loading Station
    public void moveToLoading(){
        // moveToHeight(44.5);
        ballLifter_PID.setSetpoint(12);
    }

        // Method for moving the lift to the height of the first ball level
    public void moveToFirst(){
        // moveToHeight(27.5);
        ballLifter_PID.setSetpoint(300);
    }

    // Method for moving the lift to the height of the the second ball level
    public void moveToSecond(){
        // moveToHeight(55.5);
        ballLifter_PID.setSetpoint(400);
    }

    // Moves the lifter up and down at a set speed depending on whether
    // button #6 and 7 are pressed
    public void moveManually(){
        double speed = ((-Robot.oi.everyStick.getZ() + 1.0) / 4.0)+ .5;

        if(Robot.oi.everyStick.getRawButton(6)){
            lifterMotor.setSpeed(1* speed);
        }
        else if(Robot.oi.everyStick.getRawButton(7)){
            lifterMotor.setSpeed(-.8 * speed);
        }
        else{
            lifterMotor.stopMotor();
        }
    }

    /** Moves the arm to a set height
     * 
     *  @param height the height that you want the arm to move to in inches
     */
    public void moveToHeight(double height){
        double goal = 0;

        if(height > armHeight){

        }
        else{
            double adj = height - armHeight;
        }

        moveToDegree(goal);
    }

    
    public void moveToDegree(double degree){
        ballLifter_PID.setSetpoint(degree * degreePerPulse);
    }

    // Enables/disables the PID controller so it doesn't run 
    // while the operator is manually controlling the lift system
    public void enableIntervals(){
        usingIntervals = !usingIntervals;
        if(!usingIntervals){
            System.out.println("Enabling Manual Control of the Cargo Lifter");
        }
        else{
            System.out.println("Disabling Manual Control of the Cargo Lifter");
        }
    }

    // Method to move the arm up at a set speed
    public void moveArmUp(){
        lifterMotor.set(.5);
    }

    public void moveArmDown(){
        lifterMotor.set(-.5);
    }

    public void stop(){
        lifterMotor.stopMotor();
    }

    public void reset(){
        // ballLifter_PID.disable();
        stop();
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new moveBallLifter());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

