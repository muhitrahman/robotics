import lejos.hardware.motor.Motor;
import lejos.robotics.navigation.DifferentialPilot;


public class robo_ifstatement 
	{
	DifferentialPilot pilot;
	
	
	public static void main(String[] args) 
	{
		new robo_ifstatement();		
	}
	
	
	public robo_ifstatement()
	{
		pilot = new DifferentialPilot(1.5f, 6, Motor.B, Motor.C);
		
		for (int i = 0; i < 5; i++){
			travelAndRotate();
		
			if ( i > 3){
				pilot.travel(-6);
			}
		}
	}

	
	private void travelAndRotate()
	{	
		pilot.travel(12);
		pilot.travel(90);	
	}

}
