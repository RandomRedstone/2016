package org.usfirst.frc.team2145.robot.subsystems;

import org.usfirst.frc.team2145.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class RobotLift {
	static DoubleSolenoid armds;
	static DoubleSolenoid liftds;
	public RobotLift() {
		armds = new DoubleSolenoid(4,5);
		liftds = new DoubleSolenoid(6,7);
	}
	public void controlArm() {
		if(Robot.oi.cont2Buttons[8]){
			armds.set(Value.kReverse);
		}
		if(Robot.oi.cont2Buttons[9]){
			armds.set(Value.kForward);
		}
		if(Robot.oi.cont2Buttons[10]){
			liftds.set(Value.kForward);
		}
		if(Robot.oi.cont2Buttons[11]){
			liftds.set(Value.kReverse);
		}
	}
}
