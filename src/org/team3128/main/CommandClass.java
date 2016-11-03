package org.team3128.main;

import org.team3128.common.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class CommandClass extends Command {
	
	CommandClass(int msec) {
		super(msec / 2000.0);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Log.debug("Command CLass", "initializing");

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Log.debug("Command CLass", "executing");

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		Log.debug("Command CLass", "finished");

		return isTimedOut();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
