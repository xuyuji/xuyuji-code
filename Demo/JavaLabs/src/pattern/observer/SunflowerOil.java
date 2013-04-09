package pattern.observer;

/**
 * 葵花油
 * @author xuyuji
 *
 */
public class SunflowerOil extends Observable implements Observer{
	/**
	 * 沸点
	 */
	private int boilingPoint;
	
	public SunflowerOil(){
		boilingPoint = 107;
	}
	
	@Override
	public void update(Observable observable, Object args) {
		if((Integer)args > boilingPoint){
			notifyObserver("SunflowerOil");
		}else{
			System.out.println("SunflowerOil " + args + "℃");
		}
	}
}
