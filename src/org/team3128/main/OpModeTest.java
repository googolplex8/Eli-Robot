package org.team3128.main;

import org.team3128.common.NarwhalRobot;
import org.team3128.common.drive.SRXTankDrive;
import org.team3128.common.drive.TankDrive;
import org.team3128.common.hardware.motor.MotorGroup;
import org.team3128.common.listener.ListenerManager;
import org.team3128.common.listener.controllers.ControllerExtreme3D;
import org.team3128.common.listener.controllers.ControllerXbox;
import org.team3128.common.util.GenericSendableChooser;
import org.team3128.common.util.Log;



import org.team3128.common.util.units.Length;

import com.ni.vision.NIVision.ExtremeReport;




import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Main class for our 2016 robot, the Unladen Swallow.
 */
public class OpModeTest extends NarwhalRobot {
	Joystick joystick;
	SRXTankDrive tankDrive;
	
	CANTalon drvLeft1, drvLeft2;	
	CANTalon drvRight1, drvRight2;
	MotorGroup leftMotors, rightMotors;
	ListenerManager listenerManager;

	@Override
	protected void constructHardware() {
		Log.info("OpModeTest", "Hello World");
		joystick = new Joystick(0);
		drvLeft1 = new CANTalon(0);
		drvLeft2 = new CANTalon(1);
		drvRight1 = new CANTalon(2);
		drvRight2 = new CANTalon(3);
		leftMotors = new MotorGroup(drvLeft1, drvLeft2);
		rightMotors = new MotorGroup(drvRight1, drvRight2);
		tankDrive = new SRXTankDrive(drvLeft1, drvRight1, 6 * Length.in, 1, 20 * Length.in, 15 * Length.in);
		listenerManager = new ListenerManager(joystick);
		addListenerManager(listenerManager);
		//TankDrive tankDrive = new TankDrive(leftMotors, rightMotors, encLeft, encRight, wheelCircumfrence, gearRatio, wheelBase, track);
	}

	@Override
	protected void setupListeners() {
		listenerManager.nameControl(ControllerExtreme3D.TWIST, "MoveTurn");
		listenerManager.nameControl(ControllerExtreme3D.JOYY, "MOveForward");
		listenerManager.nameControl(ControllerExtreme3D.THROTTLE, "Throttle");
		listenerManager.nameControl(ControllerExtreme3D.TRIGGER, "FullSpeed");
		listenerManager.addMultiListener(()->
		{
			tankDrive.arcadeDrive(listenerManager.getAxis("MoveTurn"), listenerManager.getAxis("MoveForwards"), listenerManager.getAxis("Throttle"), listenerManager.getButton("FullSpeed"));
		}, "MoveTurn", "MoveForwards", "Throttle", "FullSpeed");
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
