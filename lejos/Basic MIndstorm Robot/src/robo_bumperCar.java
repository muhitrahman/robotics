

import java.util.Random;
import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.utility.Delay;


public class robo_bumperCar {
	DifferentialPilot pilot;
	Random ran;
	robo_touchSensor touch;
	
	public static void main(String[] args) {
		new robo_bumperCar();
	}
	
	
	public robo_bumperCar(){
		
		pilot = new DifferentialPilot(1.5f, 6, Motor.B, Motor.C);
		ran = new Random();
		
		Brick brick = BrickFinder.getDefault();
		
		Port s1 = brick.getPort("S1");
		Port s2 = brick.getPort("S2");
		
		EV3TouchSensor sensor = new EV3TouchSensor(s1);
		EV3TouchSensor sensor2 = new EV3TouchSensor(s2);
		
		touch = new robo_touchSensor(sensor);
		touch = new robo_touchSensor(sensor2);
		
	pilot.forward();
	while(true){	
		Delay.msDelay(2);
		if (touch.press()){
			pilot.stop();
			pilot.travel(-6);
			
			if(ran.nextBoolean()){
				pilot.rotate(90);
			}else{
				pilot.rotate(-90);
			}
			pilot.forward();
		}
		if(Button.ESCAPE.isDown()){
			pilot.stop();
			sensor.close();
			sensor2.close();
			System.exit(0);
		}
	}
	
	
	}

}
