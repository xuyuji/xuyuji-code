package pattern.observer;

public class Alarm implements Observer{
	@Override
	public void update(Observable observable, Object args) {
		System.err.println(args + " boiling!");
	}
}
