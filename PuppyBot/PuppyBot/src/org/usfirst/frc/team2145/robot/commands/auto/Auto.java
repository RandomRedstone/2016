package org.usfirst.frc.team2145.robot.commands.auto;

import org.usfirst.frc.team2145.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Auto{
	static Timer t;
	static final Step[][] autos = {{new Time(0.25, 0.25, 1.0), new Time(0.75, -0.5, 1.0)}};
	static int step;
	static int mode;
	static double rspeed;
	static double lspeed;
	public Auto () {
		t = new Timer();
		
	}
	public void init() {
		step = 0;
		mode = 0;
		Robot.drivetrain.le.reset();
		Robot.drivetrain.re.reset();
		autos[mode][0].init();
		System.out.println("Autonomous initiated");	
		t.start();
		SmartDashboard.putNumber("Time", t.get());
	}
	public void run(){
		/*if (t.get() > 0 && t.get() < 5) {
			Robot.drivetrain.drive(1,1);
		}
		if (t.get() > 5 && t.get()< 8) {
			Robot.drivetrain.drive(0, 0);
		}
		if (t.get() > 8 && t.get()< 15){
			Robot.drivetrain.drive(0, 0);
		}
		if (t.get() < 15) {
			Robot.drivetrain.drive(0,0);
		}*/
		try {
			if(t.get()>=0.5){
				autos[mode][step].init();
				t.stop();
				t.reset();
			}
			if(autos[mode][step].done){
				autos[mode][step].done=false;
				step=step+1;
				autos[mode][step].done=false;
				System.out.println("Done");
			}else{
				autos[mode][step].run();
			}
			SmartDashboard.putNumber("time", t.get());
		} catch(ArrayIndexOutOfBoundsException e){
			Robot.drivetrain.drive(0, 0);
			System.out.println("Finished with autonomous");
		} catch(NullPointerException e){
			System.out.println("Stuff should be fixed or else I don't work");
		}
		
	}
}