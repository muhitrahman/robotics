

import lejos.hardware.motor.Motor;
import lejos.robotics.navigation.*;

public class robot_whileloop {

		DifferentialPilot pilot;
		boolean loop;
		
	public static void main(String[] args) {
		new robot_whileloop();
	}
	
	
	public robot_whileloop(){
		
		 pilot = new DifferentialPilot (1.5f, 6, Motor.B, Motor.C);
		
		while (true){
			travelAndRotate();
			loop=false;
		}
	}
	
	
	public void travelAndRotate(){
		pilot.travel(12);
		pilot.rotate(90);
	}

}
