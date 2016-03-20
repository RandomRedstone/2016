package org.usfirst.frc.team2145.robot.commands.auto;

public class Auto{
	static final Step[][] autos = {{new Dist(1, 1), new Dist(1, 1)}};
	static int step;
	static int mode;
	static double rspeed;
	static double lspeed;
	public Auto () {
		
	}
	public void init(int amode) {
		step=0;
		mode =0;
		autos[mode][0].init();
	}
	public void run(){
		try {
			if(autos[mode][step].done){
				step=step+1;
			}else{
				autos[mode][step].run();
			}
		} catch(ArrayIndexOutOfBoundsException e){
			
		}
	}
}