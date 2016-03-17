package org.usfirst.frc.team2145.robot.subsystems;

import org.usfirst.frc.team2145.robot.Robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	public static double[][] record;
	public static RobotDrive RDrive;
	static int time;
	public DriveTrain() {
		CANTalon rfWheel = new CANTalon(33);
		CANTalon lfWheel = new CANTalon(31);
		CANTalon rbWheel = new CANTalon(34);
		CANTalon lbWheel = new CANTalon(32);
		RDrive = new RobotDrive(lfWheel, lbWheel, rfWheel, rbWheel);
	}
	protected void initDefaultCommand() {
		
	}
	public void justARumblin() {
		if(time%30 == 0 || time%30 == 1 || time%30 == 2 || time%30 == 3){
			Robot.oi.rumble(1, 2, 10.0f);
		}else{
			Robot.oi.rumble(1, 2, 0.0f);
		}
		if((time+15)%30 == 0 || (time+15)%30 == 1 || (time+15)%30 == 2 || (time+15)%30 == 3){
			Robot.oi.rumble(2, 2, 10.0f);
		}else{
			Robot.oi.rumble(2, 2, 0.0f);
		}
	}
	public void driveWithJoystick() {
		double rT = 0;
		double lT = 0;
		double rW = 0;
		double lW = 0;
		boolean turning=false;
		if(Robot.oi.cont1Axis[0] > 0.1){
			rT=Robot.oi.cont1Axis[0]*0.5;
			turning=true;
		}else if(Robot.oi.cont1Axis[0] < -0.1){
			lT=Robot.oi.cont1Axis[0]*0.5;
			turning=true;
		}else{
			turning=false;
			lT=0;
			rT=0;
		}
		if(Robot.oi.cont1Axis[3] > 0 && Robot.oi.cont1Axis[2] == 0 && turning==false){
			rW=Robot.oi.cont1Axis[3]*0.75;
			lW=Robot.oi.cont1Axis[3]*0.75;
		}else if(Robot.oi.cont1Axis[2] > 0 && Robot.oi.cont1Axis[3] == 0 && turning==false){
			rW=-Robot.oi.cont1Axis[2]*0.75;
			lW=-Robot.oi.cont1Axis[2]*0.75;
		}else if(Robot.oi.cont1Axis[3] > 0 && Robot.oi.cont1Axis[2] == 0 && turning){
			rW=Robot.oi.cont1Axis[3]*0.5-lT;
			lW=Robot.oi.cont1Axis[3]*0.5+rT;
		}else if(Robot.oi.cont1Axis[2] > 0 && Robot.oi.cont1Axis[3] == 0 && turning){
			rW=-Robot.oi.cont1Axis[2]*0.5+lT;
			lW=-Robot.oi.cont1Axis[2]*0.5-rT;
		}
		if(Robot.oi.cont1Buttons[1]){
			rW=-Robot.oi.cont1Axis[0];
			lW=Robot.oi.cont1Axis[0];
		}
		//.Robot.oi.rumble(Robot.oi.cont1, 0, (float) lW);
		//Robot.oi.rumble(Robot.oi.cont1, 1, (float) rW);
		drive(lW,rW);
		/**time=time+1;
		if(time%5==0){
			record[time%5][0]=lW;
			record[time%5][1]=rW;
		}
		System.out.println("Previous Movement Record:");
		System.out.println(record);**/
	}
	public void drive(double left, double right){
		RDrive.tankDrive(left, right);
	}
	public void setMotor(int side, double speed) {
		if(side==0){
			CANTalon n = new CANTalon(31);
			CANTalon m = new CANTalon(32);
			m.set(speed);
			n.set(speed);
		}
		if(side==1){
			CANTalon n = new CANTalon(33);
			CANTalon m = new CANTalon(34);
			m.set(speed);
			n.set(speed);
		}
	}
	public void stop(){
		RDrive.drive(0, 0);
	}
}
