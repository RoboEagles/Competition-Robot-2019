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

import org.usfirst.frc4579.sensors.*;
import org.usfirst.frc4579.filters.*;

import com.kauailabs.navx.frc.AHRS;

import org.usfirst.frc4579.Robot2019.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SPI;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Measurement extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public Measurement() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    public double angle = 0.0;  		// Angle robot is facing (accumulated gyro readings).
	public double angleRate = 0.0;		// Instantaneous gyroZ reading.
	public double angleRateLPF = 0.0;	// Low pass filtered version of angleRate.
	public double angleRateMax = 0.0;   // Max gyroZ reading, always positive.
	public double mpuDeltaT = 0.0;		// delta T measurement from MPU.
	public double motionX = 0.0;		// Accumulated forward motion.
	public double motionY = 0.0;		// Accumulated sideways motion.
	public double speed = 0.0;			// Calculated forward speed.
	public double distance = 0.0;		// Calculated total forward distance.
	public double motionDeltaT = 0.0;	// Flow motion delta t from Flow Sensor.
	
	private FirstOrderLPF filter = new FirstOrderLPF(0.5);

	AHRS imu = new AHRS(I2C.Port.kOnboard);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    
	// ************************************* IMU METHODS ************************************** //
	// Gyro Values
	public double getIMU_GYROZ(){
		return imu.getAngle();
	}

	public double getIMU_GYROZRATE(){
		return imu.getRate();
	}

	public double getIMU_GYROZMAX(){
		return imu.getGyroFullScaleRangeDPS();
	}

	// Accelerometer values
	public double getIMU_ACCELX(){
		return imu.getWorldLinearAccelX();
	}

	public double getIMU_ACCELY(){
		return imu.getWorldLinearAccelY();
	}

	public void reset(){

	}

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new measure());

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

