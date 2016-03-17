package org.usfirst.frc.team2145.robot.commands.auto;
import org.usfirst.frc.team2145.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Auto{
	static final Step[][] autos = {
			{new Step("distance", 1, 1, 1)}};
	static Timer time;
	static int step;
	static int mode;
	static double rspeed;
	static double lspeed;
	static Encoder le;
	static Encoder re;
	public Auto () {
		time = new Timer();
		le = new Encoder(3,2);
		re = new Encoder(0,1);
	}
	public void init(int amode) {
		step=0;
		autos[mode][0].run();
	}
	public void run(){
		if(!autos[mode][step].done){
			autos[mode][step].run();
		}else{
			step=step+1;
		}
	}
}