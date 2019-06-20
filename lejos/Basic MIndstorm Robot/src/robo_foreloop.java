

import lejos.hardware.motor.Motor;
import lejos.robotics.navigation.*;

public class robo_foreloop {

		DifferentialPilot pilot;
		
		
	public static void main(String[] args) 
	{
		new robo_foreloop();
	}
	
	
	public robo_foreloop()
	{
		pilot = new DifferentialPilot (1.5f, 6, Motor.B, Motor.C);
		
		for (int i = 0; i < 3; i++){
			travelAndRotate();
			
		}
	}
	
	
	public void travelAndRotate(){
		pilot.travel(12);
		pilot.rotate(90);
	}

}
