package org.usfirst.frc.team2145.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.RumbleType;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

//This controller OI works for the ATTACK3 controller and XBOX 360 controller
//It works for up to 2 controllers
//Buttons on the ATTACK3 controller are labeled appropriatly
//Look in the drivers station under the USB sign to find the button labelings of the XBOX controller
//The first button variable is a placeholder with either controller
public class OI {
	public Joystick cont1 = new Joystick(0);
	public double[] cont1Axis = {0,0,0,0,0,0};
	public boolean[] cont1Buttons = {false,false,false,false,false,false,false,false,false,false,false};
	public int cont1POV;
	
	static String c1type;
	static String c2type;
	public Joystick cont2 = new Joystick(1);
	public double[] cont2Axis = {0,0,0,0,0,0};
	public boolean[] cont2Buttons = {false,false,false,false,false,false,false,false,false,false,false};
	public int cont2POV;
	public OI(String controller1Type, String controller2Type) {
		c1type = controller1Type;
		c2type = controller2Type;
		if(controller1Type=="XBOX"){
			cont1POV = cont1.getPOV();
			for(int i=1;i<10;i++){
				cont1Buttons[i] = new JoystickButton(cont1, i).get();
			}
			for(int i=0;i<5;i++){
				cont1Axis[i] = cont1.getRawAxis(i);
			}
		}else if(controller1Type=="Logitech"){
			for(int i=1;i<11;i++){
				cont1Buttons[i] = new JoystickButton(cont1, i).get();
			}
			for(int i=0;i<2;i++){
				cont1Axis[i] = cont1.getRawAxis(i);
			}
		}else if(controller1Type=="none"){
			
		}else{
			DriverStation.reportError("Joystick 0 not supported or found", false);
		}
		if(controller2Type=="XBOX"){
			cont2POV = cont2.getPOV();
			for(int i=1;i<10;i++){
				cont2Buttons[i] = new JoystickButton(cont2, i).get();
			}
			for(int i=0;i<5;i++){
				cont2Axis[i] = cont2.getRawAxis(i);
			}
		}else if(controller2Type=="Logitech"){
			for(int i=1;i<11;i++){
				cont1Buttons[i] = new JoystickButton(cont2, i).get();
			}
			for(int i=0;i<2;i++){
				cont2Axis[i] = cont2.getRawAxis(i);
			}
		}else if(controller2Type=="none"){
			
		}else{
			DriverStation.reportError("Joystick 1 not supported or found", false);
		}
	}
	//Call this during teleop periodic in order for it to work
	public void refreshOI() {
		if(c1type=="XBOX"){
			cont1POV = cont1.getPOV();
			for(int i=1;i<10;i++){
				cont1Buttons[i] = new JoystickButton(cont1, i).get();
			}
			for(int i=0;i<5;i++){
				cont1Axis[i] = cont1.getRawAxis(i);
			}
		}else if(c1type=="Logitech"){
			for(int i=1;i<11;i++){
				cont1Buttons[i] = new JoystickButton(cont1, i).get();
			}
			for(int i=0;i<2;i++){
				cont1Axis[i] = cont1.getRawAxis(i);
			}
		}else if(c1type=="none"){
			
		}
		if(c2type=="XBOX"){
			cont2POV = cont2.getPOV();
			for(int i=1;i<10;i++){
				cont2Buttons[i] = new JoystickButton(cont2, i).get();
			}
			for(int i=0;i<5;i++){
				cont2Axis[i] = cont2.getRawAxis(i);
			}
		}else if(c2type=="Logitech"){
			for(int i=1;i<11;i++){
				cont2Buttons[i] = new JoystickButton(cont2, i).get();
			}
			for(int i=0;i<2;i++){
				cont2Axis[i] = cont2.getRawAxis(i);
			}
		}else if(c2type=="none"){
			
		}
	}
	public void rumble(int controller, int type, float value) {
		if(controller == 1){
			if(type == 0){
				cont1.setRumble(RumbleType.kLeftRumble, value);
			}else if(type == 1){
				cont1.setRumble(RumbleType.kRightRumble, value);
			}else if(type == 2){
				cont1.setRumble(RumbleType.kLeftRumble, value);
				cont1.setRumble(RumbleType.kRightRumble, value);
			}else{
				DriverStation.reportError("Rumble type not supported", false);
			}
		}else if(controller == 1){
			if(type == 0){
				cont2.setRumble(RumbleType.kLeftRumble, value);
			}else if(type == 1){
				cont2.setRumble(RumbleType.kRightRumble, value);
			}else if(type == 2){
				cont2.setRumble(RumbleType.kLeftRumble, value);
				cont2.setRumble(RumbleType.kRightRumble, value);
			}else{
				DriverStation.reportError("Rumble type not supported", false);
			}
		}
	}
}
