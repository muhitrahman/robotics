import lejos.hardware.Button;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;

public class ColorRecognizerThread extends Thread {
 
    private EV3ColorSensor colorSensor;
    public static final int RED = 0;
    public static final int GREEN = 1;
    public static final int BLUE = 2;
    public static final int YELLOW = 3;
    public static final int MAGENTA = 4;
    public static final int ORANGE = 5;
    public static final int WHITE = 6;
    public static final int BLACK = 7;
    public static final int PINK = 8;
    public static final int GRAY = 9;
    public static final int LIGHT_GRAY = 10;
    public static final int DARK_GRAY = 11;
    public static final int CYAN = 12;
    public static final int BROWN = 13;
    public static final int NONE = -1;
    
    
    public static void main(String[] args) {
    	 final EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S2);
         final SensorMode mode = colorSensor.getColorIDMode();
         final ColorRecognizerThread colorRecognizerThread = new ColorRecognizerThread(colorSensor);
         colorRecognizerThread.start();
         Button.waitForAnyPress();
    }
    
    
    public ColorRecognizerThread(final EV3ColorSensor colorSensor) {
        this.colorSensor = colorSensor;
    }
 
    @Override
    public void run() {
        while(true){
            final int colorId = colorSensor.getColorID();
            switch (colorId){
                //RED
                case 0:
                    Button.LEDPattern(2);
                    break;
                //GREEN
                case 1:
                    Button.LEDPattern(1);
                    break;
                //BLUE
                case 2:
                    Button.LEDPattern(4);
                    threadSleep(2000);
                    Button.LEDPattern(0);
                    System.exit(0);
                //YELLOW
                case 3:
                    Button.LEDPattern(3);
                    break;
                default:
                    Button.LEDPattern(0);
            }
        }
    }
 
    private void threadSleep(final int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 
}