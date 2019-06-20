import lejos.hardware.motor.Motor;
import lejos.robotics.navigation.DifferentialPilot;


public class robot2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new robot2();
	}
	
	public robot2 (){
		
		DifferentialPilot pilot = new DifferentialPilot (1.5f, 6, Motor.B, Motor.C);
		
		pilot.travel(12);
		pilot.rotate(90);
	}

}
