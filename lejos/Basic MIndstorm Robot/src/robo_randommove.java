import java.util.Random;

import lejos.hardware.motor.Motor;
import lejos.robotics.navigation.DifferentialPilot;


public class robo_randommove 
	{
	DifferentialPilot pilot;
	Random ram;
	
	public static void main(String[] args) 
	{
		new robo_randommove();		
	}
	
	
	public robo_randommove()
	{
		pilot = new DifferentialPilot(1.5f, 6, Motor.B, Motor.C);
		ram = new Random();
		
		while (true){
			pilot.travel(12);
		
			if ( ram.nextBoolean()){
				pilot.rotate(90);
			}
			else{
				pilot.rotate(-90);
			}
		}
	}

	
	private void travelAndRotate()
	{	
		pilot.travel(12);
		pilot.travel(90);	
	}

}
