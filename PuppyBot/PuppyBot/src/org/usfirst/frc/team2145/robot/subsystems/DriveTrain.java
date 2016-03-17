package org.usfirst.frc.team2145.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	static Talon rWheel;
	static Talon lWheel;
	static double ll;
	static double rl;
	public DriveTrain() {
		rWheel = new Talon(0);
		lWheel = new Talon(9);
	}
	public void run(){
		rWheel.set(-rl*0.75);
		lWheel.set(ll*0.75);
	}
	public void drive(double l, double r) {
		rl=r;
		ll=l;
	}
	protected void initDefaultCommand() {
		
	}
	public void stop() {
		
	}	
}
