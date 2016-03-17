package org.usfirst.frc.team2145.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PCM extends Subsystem{
	public static Compressor comp;
	public static Solenoid sol;
	protected void initDefaultCommand() {
		
	}
	public static void PMC(int CompID, int SolenoidID) {
		comp = new Compressor(CompID);
		sol = new Solenoid(SolenoidID);
	}
	public static void buildPSI() {
		if(sol.get()==false){
			comp.setClosedLoopControl(true);
		}
		if(sol.get()){
			sol.set(false);
		}
	}
	public static void releasePressure(){
		if(sol.get()){
			sol.set(true);
		}else{
			sol.set(false);
		}
	}
}
