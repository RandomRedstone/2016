package org.usfirst.frc.team2145.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	public Encoder le;
	public Encoder re;
	static Talon rWheel;
	static Talon lWheel;
	public boolean i;
	public DriveTrain() {
		rWheel = new Talon(0);
		lWheel = new Talon(9);
	}
	public void meth() {
		if(!i){
			le = new Encoder(0,1);
			re = new Encoder(3,2);
			le.setDistancePerPulse(Math.PI*8/360);
			re.setDistancePerPulse(Math.PI*8/360);
			i=true;
		}
	}
	public void drive(double l, double r) {
		rWheel.set(-r*0.5);
		lWheel.set(l*0.5);
	}
	protected void initDefaultCommand() {
		
	}
	public void stop() {
		
	}	
}
