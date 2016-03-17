package org.usfirst.frc.team2145.robot.subsystems;

import org.usfirst.frc.team2145.robot.Robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;

public class BoulderArm {
	static LimitHandler lh;
	static CANTalon lLaunch;
	static CANTalon rLaunch;
	static Solenoid piston;
	static DigitalInput lswitch;
	public BoulderArm() {
		lh = new LimitHandler();
		lLaunch = new CANTalon(22);
		rLaunch = new CANTalon(21);
		piston = new Solenoid(10, 3);
	}
	public void doStuff() {
		lh.run();
		if(Robot.oi.cont2Buttons[1]){
			piston.set(true);
		}else{
			piston.set(false);
		}
		if(Robot.oi.cont2Buttons[5]){
			lLaunch.set(0.5);
			rLaunch.set(-0.5);
		}else if(Robot.oi.cont2Buttons[6]){
			lLaunch.set(-0.75);
			rLaunch.set(0.75);
		}else{
			lLaunch.set(0);
			rLaunch.set(0);
		}
	}
}
