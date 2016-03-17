package org.usfirst.frc.team2145.robot.subsystems;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class TargetFind {
	static NetworkTable nt;
	static double cArea;
	public void getValues() {
		nt = NetworkTable.getTable("GRIP/myContoursReport");
		double[] defaultValues = new double[0];
		double[] areas = nt.getNumberArray("areas", defaultValues);
		for(double area:areas){
			cArea = area;
		}
	}
	public void getTarget(boolean aim) {
		getValues();
	}
}
