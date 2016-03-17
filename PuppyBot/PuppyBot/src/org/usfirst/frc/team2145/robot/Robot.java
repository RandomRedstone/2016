package org.usfirst.frc.team2145.robot;

import org.usfirst.frc.team2145.robot.commands.auto.Auto;
import org.usfirst.frc.team2145.robot.subsystems.Camera;
import org.usfirst.frc.team2145.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2145.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team2145.robot.subsystems.RobotLift;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot{
	public static DriveTrain drivetrain;
	public static OI oi;
	public static Auto auto;
	public static Subsystem examplesubsystem = new ExampleSubsystem();
	public static Camera cam;
	public static Joystick controller1;
	static int autoMode;
	public Encoder[] en = {null, null};
	public static RobotLift rl;
	public void robotInit (){
		drivetrain = new DriveTrain();
		oi = new OI("XBOX", "Logitech");
		auto = new Auto();
		cam = new Camera();
		cam.loadCamera();
		cam.initCamera();
		controller1 = new Joystick(0);
		//rl = new RobotLift();
	}
	public void disabledPeriodic(){
		int pov;
		if(controller1.getPOV()>=0){
			pov = controller1.getPOV()/45;
		}else{
			pov = -1;
		}
		if(pov==0){
			autoMode=0;
		}
		SmartDashboard.putNumber("POV", pov);
		Scheduler.getInstance().run();
		cam.periodicCamera();
	}
	public void autonomousInit() {
		cam.initCamera();
		auto.init(autoMode);
	}
	public void autonomousPeriodic() {
		drivetrain.run();
		auto.execute();
		cam.periodicCamera();
	}
	public void teleopInit() {
		LiveWindow.run();
		cam.initCamera();
	}
	public void teleopPeriodic() {
		drivetrain.run();
		cam.periodicCamera();
		oi.refreshOI();
		double rT = 0;
		double lT = 0;
		double rW = 0;
		double lW = 0;
		//rl.controlArm();
		if(oi.cont1Axis[0] > 0.2){
			lT=oi.cont1Axis[0]*0.25;
		}
		if(oi.cont1Axis[0] < -0.2){
			rT=-oi.cont1Axis[0]*0.25;
		}
		if(oi.cont1Axis[3] > 0){
			rW=oi.cont1Axis[3]*0.5+rT;
			lW=oi.cont1Axis[3]*0.5+lT;
		}
		if(oi.cont1Axis[2] > 0){
			rW=-oi.cont1Axis[2]*0.5-rT;
			lW=-oi.cont1Axis[2]*0.5-lT;
		}
		if(oi.cont1Buttons[1]){
			rW=-oi.cont1Axis[0]*0.75;
			lW=oi.cont1Axis[0]*0.75;
		}
		if(oi.cont1Axis[2] > 0 && oi.cont1Axis[3] > 0){
			rW=0;
			lW=0;
		}
		drivetrain.drive(lW,rW);
	}
	public void testPeriodic() {
		LiveWindow.run();
	}
	public void test() {
		
	}
}