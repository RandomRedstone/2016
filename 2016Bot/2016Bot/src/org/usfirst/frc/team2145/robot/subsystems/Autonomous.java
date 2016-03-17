package org.usfirst.frc.team2145.robot.subsystems;

import org.usfirst.frc.team2145.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;

public class Autonomous {
	static int step;
	static Encoder le;
	static Encoder re;
	static double wheelC = 8*Math.PI;
	static double ticks;
	static double lspeed;
	static double rspeed;
	static double average;
	static double ldist;
	static double rdist;
	public int am;
	static final double[][] s1 = {{67.3,-67.3},{-114.9,-114.9},{67.3,-67.3},{16.8,-16.8},{104.4,104.4}};
	static final double[][] s2 = {{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
	static final double[][] s3 = {{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
	static final double[][] s4 = {{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
	static final double[][] s5 = {{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
	static final double[][] s6 = {{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
	public Autonomous() {
		re = new Encoder(3,4);
		le = new Encoder(2,1);
		re.setDistancePerPulse(wheelC);
		le.setDistancePerPulse(wheelC);
		am=0;
	}
	public void init() {
		step=0;
		re.reset();
		le.reset();
	}
	public void run() {
		if(am==1){
			if(s1[step][0]<0){
				ldist=-le.getDistance();
			}else{
				ldist=le.getDistance();
			}
			if(s1[step][1]<0){
				rdist=re.getDistance();
			}else{
				rdist=re.getDistance();
			}
			average=(abs(s1[step][1]+s1[step][0]))/2;
			lspeed = (s1[step][0]/average)*0.5;
			rspeed = (s1[step][1]/average)*0.5;
			Robot.drivetrain.drive(lspeed, rspeed);
			if(ldist>=s1[step][0] && rdist>=s1[step][1] && step<=s1.length-1){
				step=step+1;
				ldist=0;
				rdist=0;
				re.reset();
				le.reset();
			}else if(ldist>=s1[step][0] && rdist>=s1[step][1] && step<=s1.length-1){
				Robot.drivetrain.drive(0,0);
			}
		}else if(am==2){
			if(s2[step][0]<0){
				ldist=-le.getDistance();
			}else{
				ldist=le.getDistance();
			}
			if(s2[step][1]<0){
				rdist=re.getDistance();
			}else{
				rdist=re.getDistance();
			}
			average=(abs(s2[step][1]+s2[step][0]))/2;
			lspeed = (s2[step][0]/average)*0.5;
			rspeed = (s2[step][1]/average)*0.5;
			Robot.drivetrain.drive(lspeed, rspeed);
			if(ldist>=s2[step][0] && rdist>=s2[step][1] && step<=s2.length-1){
				step=step+1;
				ldist=0;
				rdist=0;
				re.reset();
				le.reset();
			}else if(ldist>=s2[step][0] && rdist>=s2[step][1] && step<=s2.length-1){
				Robot.drivetrain.drive(0,0);
			}
		}else if(am==3){
			if(s3[step][0]<0){
				ldist=-le.getDistance();
			}else{
				ldist=le.getDistance();
			}
			if(s3[step][1]<0){
				rdist=re.getDistance();
			}else{
				rdist=re.getDistance();
			}
			average=(abs(s3[step][1]+s3[step][0]))/2;
			lspeed = (s3[step][0]/average)*0.5;
			rspeed = (s3[step][1]/average)*0.5;
			Robot.drivetrain.drive(lspeed, rspeed);
			if(ldist>=s3[step][0] && rdist>=s3[step][1] && step<=s3.length-1){
				step=step+1;
				ldist=0;
				rdist=0;
				re.reset();
				le.reset();
			}else if(ldist>=s3[step][0] && rdist>=s3[step][1] && step<=s3.length-1){
				Robot.drivetrain.drive(0,0);
			}
		}else if(am==4){
			if(s4[step][0]<0){
				ldist=-le.getDistance();
			}else{
				ldist=le.getDistance();
			}
			if(s4[step][1]<0){
				rdist=re.getDistance();
			}else{
				rdist=re.getDistance();
			}
			average=(abs(s4[step][1]+s4[step][0]))/2;
			lspeed = (s4[step][0]/average)*0.5;
			rspeed = (s4[step][1]/average)*0.5;
			Robot.drivetrain.drive(lspeed, rspeed);
			if(ldist>=s4[step][0] && rdist>=s4[step][1] && step<=s4.length-1){
				step=step+1;
				ldist=0;
				rdist=0;
				re.reset();
				le.reset();
			}else if(ldist>=s4[step][0] && rdist>=s4[step][1] && step<=s4.length-1){
				Robot.drivetrain.drive(0,0);
			}
		}else if(am==5){
			if(s5[step][0]<0){
				ldist=-le.getDistance();
			}else{
				ldist=le.getDistance();
			}
			if(s5[step][1]<0){
				rdist=re.getDistance();
			}else{
				rdist=re.getDistance();
			}
			average=(abs(s5[step][1]+s5[step][0]))/2;
			lspeed = (s5[step][0]/average)*0.5;
			rspeed = (s5[step][1]/average)*0.5;
			Robot.drivetrain.drive(lspeed, rspeed);
			if(ldist>=s5[step][0] && rdist>=s5[step][1] && step<=s5.length-1){
				step=step+1;
				ldist=0;
				rdist=0;
				re.reset();
				le.reset();
			}else if(ldist>=s5[step][0] && rdist>=s5[step][1] && step<=s5.length-1){
				Robot.drivetrain.drive(0,0);
			}
		}else if(am==6){
			if(s6[step][0]<0){
				ldist=-le.getDistance();
			}else{
				ldist=le.getDistance();
			}
			if(s6[step][1]<0){
				rdist=re.getDistance();
			}else{
				rdist=re.getDistance();
			}
			average=(abs(s6[step][1]+s6[step][0]))/2;
			lspeed = (s6[step][0]/average)*0.5;
			rspeed = (s6[step][1]/average)*0.5;
			Robot.drivetrain.drive(lspeed, rspeed);
			if(ldist>=s6[step][0] && rdist>=s6[step][1] && step<=s6.length-1){
				step=step+1;
				ldist=0;
				rdist=0;
				re.reset();
				le.reset();
			}else if(ldist>=s6[step][0] && rdist>=s6[step][1] && step<=s6.length-1){
				Robot.drivetrain.drive(0,0);
			}
		}
	}
	private double abs(double d) {
		if(d < 0){
			return -d;
		}else if(d>0){
			return d;
		}else{
			return 0;
		}
		
	}
}
