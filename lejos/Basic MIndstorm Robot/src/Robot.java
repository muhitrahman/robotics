
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import lejos.remote.ev3.RMIRegulatedMotor;
import lejos.remote.ev3.RemoteEV3;



public class Robot {


	RemoteEV3 ev3;
	
	static RMIRegulatedMotor motorB;
	static RMIRegulatedMotor motorC;
	static boolean stop=false;
	
	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub

		
		RemoteEV3 ev3 = new RemoteEV3 ("10.0.1.1");
		ev3.isLocal();
	
		ev3.getPort("B");
		ev3.getPort("C");
		
	if (motorB==null){motorB= ev3.createRegulatedMotor("B", 'L');}
	if (motorC==null){motorC= ev3.createRegulatedMotor("C", 'L');}
	
	while (!stop){
		motorB.forward();
		motorC.forward();
		timer();
		motorB.stop(true);
		motorC.stop(true);
	    stop = true;
		}
	
	if(stop)
		{
		motorB.close();
		motorC.close();
		}
	}
	
	public static void timer(){
		
		try{
			Thread.sleep(5000);
			}
			
		catch(InterruptedException e)
			{
			e.printStackTrace();
			}        
	
		}
		
	}


