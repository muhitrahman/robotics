import lejos.hardware.motor.Motor;
import lejos.robotics.navigation.DifferentialPilot;


public class robo_methodcall {
	
	DifferentialPilot pilot;
	
	public static void main(String[] args) {
		new robo_methodcall();
	}
	
	public robo_methodcall(){
		pilot = new DifferentialPilot(1.5f, 6, Motor.B, Motor.C);
		travelAndRotte();
		travelAndRotte();
	}
	
	public void travelAndRotte(){
		pilot.travel(12);
		pilot.rotate(90);
	}

}
