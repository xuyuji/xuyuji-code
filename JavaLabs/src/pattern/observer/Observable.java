package pattern.observer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * 被观察者
 * @author xuyuji
 *
 */
public class Observable {
	
	Set<Observer> observers;
	
	public Observable(){
		observers = new HashSet<Observer>();
	}
	
	public synchronized void addObserver(Observer observer){
		observers.add(observer);
	}
	
	public synchronized void delObserver(Observer observer){
		observers.remove(observer);
	}
	
	public void notifyObserver(Object args){
		if(observers.size() > 0){
			Iterator<Observer> it = observers.iterator();
			while(it.hasNext()){
				it.next().update(this, args);
			}
		}
	}
}
