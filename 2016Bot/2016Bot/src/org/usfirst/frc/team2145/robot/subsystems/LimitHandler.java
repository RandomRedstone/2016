package org.usfirst.frc.team2145.robot.subsystems;

import org.usfirst.frc.team2145.robot.Robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;

public class LimitHandler{
	static CANTalon axisMotor;
	static int lastDirection;
	static DigitalInput lswitch;
	static int allowedDirection;
	public LimitHandler() {
		axisMotor = new CANTalon(20);
		lastDirection = 0;
		lswitch = new DigitalInput(5);
	}
	public void run() {
		if(Robot.oi.cont2Axis[1]>0.2 && lswitch.get()==false){
			axisMotor.set(-Robot.oi.cont2Axis[1]*0.15);
			lastDirection=-1;
		}else if(Robot.oi.cont2Axis[1]<-0.2){
			axisMotor.set(-Robot.oi.cont2Axis[1]*0.25);
			lastDirection=1;
		}else{
			axisMotor.set(0);
		}
		if(lastDirection == -1 && lswitch.get()){
			allowedDirection=1;
		}else if(lastDirection == 1 && lswitch.get()){
			allowedDirection=-1;
		}else{
			allowedDirection=0;
		}
	}
}
