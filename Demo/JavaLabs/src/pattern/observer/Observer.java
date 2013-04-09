package pattern.observer;

/**
 * 观察者
 * @author xuyuji
 *
 */
public interface Observer {
	public void update(Observable observable, Object args);
}
