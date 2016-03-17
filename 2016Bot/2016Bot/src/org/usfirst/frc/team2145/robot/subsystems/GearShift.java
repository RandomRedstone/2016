package org.usfirst.frc.team2145.robot.subsystems;

import org.usfirst.frc.team2145.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearShift extends Subsystem {
	public DoubleSolenoid dsol;
	protected void initDefaultCommand() {
		
	}
	public GearShift() {
		dsol = new DoubleSolenoid(10, 2, 0);
	}
	public void switchGear() {
		if(Robot.oi.cont1Buttons[3]){
			dsol.set(DoubleSolenoid.Value.kForward);
		}
		if(Robot.oi.cont1Buttons[4]){
			dsol.set(DoubleSolenoid.Value.kReverse);
		}
	}
}
