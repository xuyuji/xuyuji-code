package pattern.observer;

/**
 * 水
 * @author xuyuji
 *
 */
public class Water extends Observable implements Observer{
	/**
	 * 沸点
	 */
	private int boilingPoint;
	
	public Water(){
		boilingPoint = 100;
	}
	
	@Override
	public void update(Observable observable, Object args) {
		if((Integer)args > boilingPoint){
			notifyObserver("Water");
		}else{
			System.out.println("Water " + args + "℃");
		}
	}
}
