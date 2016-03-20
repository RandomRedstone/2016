package org.usfirst.frc.team2145.robot.subsystems;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.Point;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Camera extends Subsystem{
	int session = 0;
	Image frame;
	int tSize [] = {0,0};
	int tPos [] = {0,0};
	NIVision.Rect rect;
	@Override
	protected void initDefaultCommand() {
		
	}
	public void loadCamera() {
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		session = NIVision.IMAQdxOpenCamera("cam0", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
	}
	public void initCamera() {
		NIVision.IMAQdxConfigureGrab(session);
		NIVision.IMAQdxStartAcquisition(session);
	}
	public void initTarget(int x, int y, int w, int h) {
		tSize[0]=w;
		tSize[1]=h;
		tPos[0]=x;
		tPos[1]=y;
		rect = new NIVision.Rect(x, y, w, h);
	}
	public void periodicCamera() {
		NIVision.IMAQdxGrab(session, frame, 1);
		CameraServer.getInstance().setImage(frame);
	}
	public void stopCamera() {
		NIVision.IMAQdxStopAcquisition(session);
	}
	public void drawTarget(){
		NIVision.imaqDrawShapeOnImage(frame, frame, rect, DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
	}
	public void drawLine(int x,int y,int xx,int yy) {
		NIVision.imaqDrawLineOnImage(frame, frame, DrawMode.DRAW_VALUE, new Point(x,y), new Point(xx,yy), 0.0f);
	}
}
