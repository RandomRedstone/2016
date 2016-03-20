package org.usfirst.frc.team2145.robot;

import org.usfirst.frc.team2145.robot.commands.auto.Auto;
import org.usfirst.frc.team2145.robot.subsystems.BoulderArm;
import org.usfirst.frc.team2145.robot.subsystems.Camera;
import org.usfirst.frc.team2145.robot.subsystems.Compress;
import org.usfirst.frc.team2145.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2145.robot.subsystems.GearShift;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	public static Auto auto;
	public static BoulderArm ba;
	public static Camera cam;
	static int amode;
    public void robotInit() {
    	cam = new Camera();
    	cam.loadCamera();
		oi = new OI("XBOX","Logitech");
		drivetrain = new DriveTrain();
		gs = new GearShift();
		comp = new Compress();
		ba = new BoulderArm();
		auto = new Auto();
		cam.initCamera();
    }
    public void disabledInit(){
    	oi.rumble(1, 2, 0.0f);
    	oi.rumble(2, 2, 0.0f);
    }
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
    	cam.periodicCamera();
    	int pov;
		if(oi.cont1POV>=0){
			pov = oi.cont1POV/45;
		}else{
			pov = -1;
		}
		if(pov==0){
			amode=0;
		}
		SmartDashboard.putNumber("POV", pov);
	}
    public void autonomousInit() {
        auto.init(amode);
    }
    public void autonomousPeriodic() {
    	Scheduler.getInstance().run();
    	auto.run();
    }
    public void teleopInit() {
    	LiveWindow.run();
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
