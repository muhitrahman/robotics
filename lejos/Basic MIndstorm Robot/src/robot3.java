import lejos.hardware.motor.Motor;
import lejos.robotics.navigation.DifferentialPilot;

public class robot3 {

		DifferentialPilot pilot;

		public static void main (String[]args){
			new robot3();//this is a constructor of this class. its allow a class to set up before executing any other methods. 
	}
	
		public robot3(){//this is a constructor of this class
			pilot = new DifferentialPilot (1.5f, 6, Motor.B, Motor.C);
			travelAndRotate();
			travelAndRotate();
			
		}

		private void travelAndRotate() {
			pilot.travel(12);
			pilot.rotate(90);
			
		}
		
}
