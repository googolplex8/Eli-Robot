package org.team3128.main;

import org.team3128.common.NarwhalRobot;
import org.team3128.common.drive.TankDrive;
import org.team3128.common.hardware.motor.MotorGroup;
import org.team3128.common.listener.ListenerManager;
import org.team3128.common.listener.controllers.ControllerXbox;
import org.team3128.common.util.GenericSendableChooser;
import org.team3128.common.util.Log;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Main class for our 2016 robot, the Unladen Swallow.
 */
public class MainMotorTest extends NarwhalRobot {
	Joystick joystick;
	Talon leftMotor1, leftMotor2;
	MotorGroup leftMotors;
	ListenerManager listenerManager;

	@Override
	protected void constructHardware() {
		Log.info("MainTemplate", "Hello World");
		joystick = new Joystick(0);
		leftMotor1 = new Talon(8);
		leftMotor2 = new Talon(9);
		leftMotors = new MotorGroup(leftMotor1, leftMotor2);
		listenerManager = new ListenerManager(joystick);
		addListenerManager(listenerManager);
		//TankDrive tankDrive = new TankDrive(leftMotors, rightMotors, encLeft, encRight, wheelCircumfrence, gearRatio, wheelBase, track);
	}

	@Override
	protected void setupListeners() {
		listenerManager.nameControl(ControllerXbox.JOY1Y, "MoveLeft");
		listenerManager.addListener("MoveLeft", (double joyY) -> {
			leftMotors.setTarget(joyY);
		});
	}

	@Override
	protected void disabledInit() {

	}

	@Override
	protected void autonomousInit() {

	}

	@Override
	protected void teleopInit() {

	}

	@Override
	protected void teleopPeriodic() {
		double power = joystick.getRawAxis(ControllerXbox.JOY1Y.getIndex());
		leftMotors.setTarget(power);
	}

	@Override
	protected void constructAutoPrograms(
			GenericSendableChooser<CommandGroup> autoChooser) {

	}

	@Override
	protected void updateDashboard() {

	}

}
