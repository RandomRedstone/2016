package org.usfirst.frc.team2145.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Compress extends Subsystem{
	public static Compressor comp;
	public Compress() {
		comp = new Compressor(0);
	}
	public void controlCompressor() {
		comp.setClosedLoopControl(true);
		/**if(comp.getPressureSwitchValue()){
			comp.setClosedLoopControl(true);
		}else{
			comp.setClosedLoopControl(false);
		}**/
	}
	@Override
	protected void initDefaultCommand() {
		
	}
}
