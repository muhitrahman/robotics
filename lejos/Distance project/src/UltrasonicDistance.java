


package pack;

import pack.Ultrasonic;
import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.utility.Delay;

public class UltrasonicDistance {

	DifferentialPilot pilot;
	Ultrasonic ultrasonic;
	
	public static void main(String[] args) {
		new UltrasonicDistance();
	}

		
	public UltrasonicDistance(){
		pilot = new DifferentialPilot (1.5f, 6, Motor.B, Motor.C);
		Brick b = BrickFinder.getDefault();
		Port s4 = b.getPort("S4");
		
		EV3UltrasonicSensor us = new EV3UltrasonicSensor(s4);
		
		//us.enable();
		//us.enable();
		
		//ultrasonic = new Ultrasonic(us.getMode("Distance"));
		ultrasonic = new Ultrasonic(us.getDistanceMode());
		
		
		while(true){
			Delay.msDelay(1000);
			
			float distance = ultrasonic.distance();
			
			if (distance>0.3){
				pilot.backward();
			
			}else if(distance<0.3){
				//pilot.forward();
				pilot.rotate(90);
				pilot.backward();
				Delay.msDelay(2000);
				pilot.stop();
			}else{
				pilot.stop();
				
			}
			
			if (Button.ESCAPE.isDown()){
			pilot.stop();
			us.close();
			System.exit(0);
			}
		 }
		  
	  }
	
	}
	
	
	