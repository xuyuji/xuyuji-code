package pattern.observer;

import java.util.concurrent.TimeUnit;

/**
 * 加热器
 * @author xuyuji
 *
 */
public class Heater extends Observable{
	/**
	 * 温度
	 */
	private int temperature;
	/**
	 * 加热器最大温度
	 */
	private int maxT;
	
	public Heater(int temperature){
		this.temperature = temperature;
		maxT = 120;
	}
	
	public void Heating(){
		for(int i = temperature; i <= maxT; i++){
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			notifyObserver(i);
		}
	}
}
