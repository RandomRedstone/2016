package org.usfirst.frc.team2145.robot.commands.auto;

public abstract class Step {

	protected boolean done = false;
	/**
	 * @param type can be either "distance" or "time"
	 * @param left is the speed of the wheel if type is "time" and the distance of the wheel if the type is "distance"
	 * @param right is the speed of the wheel if type is "time" and the distance of the wheel if the type is "distance"
	 * @param only used if type is "time" otherwise it will default to 0
	 * **/
	protected Step() {
		
	}
	protected abstract void init();
	protected abstract void run();
	protected abstract void stop();
}
