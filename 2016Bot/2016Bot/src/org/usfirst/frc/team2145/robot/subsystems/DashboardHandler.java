package org.usfirst.frc.team2145.robot.subsystems;

import org.usfirst.frc.team2145.robot.Robot;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DashboardHandler extends Subsystem{
	public boolean[] buttons = {false,false,false,false,false,false};
	protected void initDefaultCommand() {
			
	}
	public DashboardHandler() {
		SmartDashboard.putBoolean("red-pos1", false);
		SmartDashboard.putBoolean("red-pos2", false);
		SmartDashboard.putBoolean("red-pos3", false);
		SmartDashboard.putBoolean("blue-pos1", false);
		SmartDashboard.putBoolean("blue-pos2", false);
		SmartDashboard.putBoolean("blue-pos3", false);
	}
	public void dashboardPeriodic() {
		buttons[0]=SmartDashboard.getBoolean("red-pos1");
		buttons[1]=SmartDashboard.getBoolean("red-pos2");
		buttons[2]=SmartDashboard.getBoolean("red-pos3");
		buttons[3]=SmartDashboard.getBoolean("blue-pos1");
		buttons[4]=SmartDashboard.getBoolean("blue-pos2");
		buttons[5]=SmartDashboard.getBoolean("blue-pos3");
		if(buttons[0]){
			Robot.auto.am=1;
			buttons[1]=false;
			buttons[2]=false;
			SmartDashboard.putBoolean("red-pos2", false);
			SmartDashboard.putBoolean("red-pos3", false);
		}else if(buttons[1]){
			Robot.auto.am=2;
			buttons[0]=false;
			buttons[2]=false;
			SmartDashboard.putBoolean("red-pos1", false);
			SmartDashboard.putBoolean("red-pos3", false);
		}else if(buttons[2]){
			Robot.auto.am=3;
			buttons[1]=false;
			buttons[0]=false;
			SmartDashboard.putBoolean("red-pos2", false);
			SmartDashboard.putBoolean("red-pos1", false);
		}
		if(buttons[3]){
			Robot.auto.am=1;
			buttons[4]=false;
			buttons[5]=false;
			SmartDashboard.putBoolean("blue-pos2", false);
			SmartDashboard.putBoolean("blue-pos3", false);
		}else if(buttons[4]){
			Robot.auto.am=1;
			buttons[3]=false;
			buttons[5]=false;
			SmartDashboard.putBoolean("blue-pos1", false);
			SmartDashboard.putBoolean("blue-pos3", false);
		}else if(buttons[5]){
			Robot.auto.am=1;
			buttons[4]=false;
			buttons[3]=false;
			SmartDashboard.putBoolean("blue-pos2", false);
			SmartDashboard.putBoolean("blue-pos1", false);
		}
		if(buttons[0] || buttons[4]){
			
		}
	}
}
