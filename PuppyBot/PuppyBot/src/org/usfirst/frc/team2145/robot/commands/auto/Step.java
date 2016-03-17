package org.usfirst.frc.team2145.robot.commands.auto;

import org.usfirst.frc.team2145.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;

public class Step {
	private String type;
	private double left;
	private double right;
	private double time;
	public boolean done;
	static Timer timer;
	static Encoder le;
	static Encoder re;
	/**
	 * @param type can be either "distance" or "time"
	 * @param left is the speed of the wheel if type is "time" and the distance of the wheel if the type is "distance"
	 * @param right is the speed of the wheel if type is "time" and the distance of the wheel if the type is "distance"
	 * @param only used if type is "time" otherwise it will default to 0
	 * **/
	public Step(String type, double left, double right, double time) {
		this.type=type;
		this.left=left;
		this.right=right;
		if(type=="distance"){
			this.time=0;
		}else if(type=="time"){
			this.time=time;
		}else{
			DriverStation.reportError("Invalid type of done", false);
		}
	}
	public void init() {
		if(type=="distance"){
			le = new Encoder(3,2);
			re = new Encoder(0,1);
			re.reset();
			le.reset();
			le.setDistancePerPulse(8*Math.PI/360);
			re.setDistancePerPulse(8*Math.PI/360);
		}else if(type=="time"){
			timer.reset();
			timer.start();
		}
	}
	public void run() {
		if(type=="distance"){
			if(this.left<0){
				if(this.right<0){
					if(le.getDistance()<=this.left && re.getDistance()<=this.right){
						done=true;
					}
				}
				if(this.right>0){
					if(le.getDistance()<=this.left && re.getDistance()>=this.right){
						done=true;
					}
				}
			}else if(this.left>0){
				if(this.right<0){
					if(le.getDistance()>=this.left && re.getDistance()<=this.right){
						done=true;
					}
				}
			if(this.right>0){
				if(le.getDistance()>=this.left && re.getDistance()>=this.right){
					done=true;
				}
			}
			Robot.drivetrain.drive(left/((left+right)/2)*0.5, right/((left+right)/2)*0.5);
		}else if(type=="time"){
			if(timer.get()>=time){
				done=true;
			}else{
				Robot.drivetrain.drive(left, right);
			}
		}
	}
}
}
