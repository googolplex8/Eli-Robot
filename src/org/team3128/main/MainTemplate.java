package org.team3128.main;


import org.team3128.common.NarwhalRobot;
import org.team3128.common.util.GenericSendableChooser;
import org.team3128.common.util.Log;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Main class for our 2016 robot, the Unladen Swallow.
 */
public abstract class MainTemplate extends NarwhalRobot
{
	
	@Override
	protected void constructHardware()
	{	
		Log.info("Template", "Loading robot: 2016 Template");
	}
	
	@Override
	protected void setupListeners()
	{
		
	}

	@Override
	protected void disabledInit()
	{

	}

	@Override
	protected void autonomousInit()
	{
		
	}
	
	@Override
	protected void teleopInit()
	{	
		
	}
	
	@Override
	protected void constructAutoPrograms(GenericSendableChooser<CommandGroup> autoChooser)
	{
		
	}

	@Override
	protected void updateDashboard()
	{
		
	}

}
