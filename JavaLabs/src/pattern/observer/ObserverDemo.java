package pattern.observer;

public class ObserverDemo {
	public static void main(String[] args) {
		Heater heater = new Heater(90);
		Water water = new Water();
		SunflowerOil sunflowerOil = new SunflowerOil();
		Alarm alarm = new Alarm();
		
		water.addObserver(alarm);
		sunflowerOil.addObserver(alarm);
		heater.addObserver(water);
		heater.addObserver(sunflowerOil);
		
		heater.Heating();
	}
}
