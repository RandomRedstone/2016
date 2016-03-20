package org.usfirst.frc.team2145.robot.commands.auto;

public abstract class Step {
	protected double left;
	protected double right;
	protected boolean done;
	/**
	 * @param type can be either "distance" or "time"
	 * @param left is the speed of the wheel if type is "time" and the distance of the wheel if the type is "distance"
	 * @param right is the speed of the wheel if type is "time" and the distance of the wheel if the type is "distance"
	 * @param only used if type is "time" otherwise it will default to 0
	 * **/
	protected Step(double left, double right) {
		this.left = left;
		this.right = right;
		this.done = false;
	}
	protected abstract void init();
	protected abstract void run();
}
