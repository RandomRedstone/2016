package org.usfirst.frc.team2145.robot;

import org.usfirst.frc.team2145.robot.subsystems.Autonomous;
import org.usfirst.frc.team2145.robot.subsystems.BoulderArm;
import org.usfirst.frc.team2145.robot.subsystems.Camera;
import org.usfirst.frc.team2145.robot.subsystems.Compress;
import org.usfirst.frc.team2145.robot.subsystems.DashboardHandler;
import org.usfirst.frc.team2145.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2145.robot.subsystems.GearShift;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static OI oi;
	public static DriveTrain drivetrain;
	public static GearShift gs;
	public static Compress comp;
	public static Autonomous auto;
	public static BoulderArm ba;
	public static Camera cam;
	public static DashboardHandler dh;
    public void robotInit() {
    	cam = new Camera();
    	cam.loadCamera();
		oi = new OI("XBOX","Logitech");
		drivetrain = new DriveTrain();
		gs = new GearShift();
		comp = new Compress();
		ba = new BoulderArm();
		auto = new Autonomous();
		dh = new DashboardHandler();
    }
    public void disabledInit(){
    	oi.rumble(1, 2, 0.0f);
    	oi.rumble(2, 2, 0.0f);
    }
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
    public void autonomousInit() {
        //auto.init();
    }
    public void autonomousPeriodic() {
    	Scheduler.getInstance().run();
    	//auto.run();
    }
    public void teleopInit() {
    	LiveWindow.run();
    	cam.initCamera();
    }
    public void teleopPeriodic() {
    	cam.periodicCamera();
    	oi.refreshOI();
    	drivetrain.driveWithJoystick();
    	gs.switchGear();
    	comp.controlCompressor();
    	gs.dsol.clearAllPCMStickyFaults();
    	ba.doStuff();
    }
    public void testPeriodic() {
    	
    }
}
