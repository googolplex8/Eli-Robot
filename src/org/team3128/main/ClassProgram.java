package org.team3128.main;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ClassProgram extends CommandGroup {
	ClassProgram(){
		addSequential(new CommandClass(2));
	}
}

