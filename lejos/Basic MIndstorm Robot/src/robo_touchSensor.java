

import lejos.robotics.SampleProvider;
import lejos.robotics.filter.AbstractFilter;


public class robo_touchSensor extends AbstractFilter {

	float [] sample;
	
	public robo_touchSensor(SampleProvider source) {
		super(source);
		sample = new float[sampleSize];
	}
	
	
	public boolean press(){
		super.fetchSample(sample, 0);
		
		if (sample[0] == 0){
			return false;
		}
		
		else{
			return true;
		}
	}

}
