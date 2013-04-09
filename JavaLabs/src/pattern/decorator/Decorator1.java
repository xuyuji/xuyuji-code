package pattern.decorator;

public class Decorator1 implements Sourcable {

	Sourcable sourcable;
	
	public Decorator1(Sourcable sourcable) {
		this.sourcable = sourcable;
	}
	
	@Override
	public void operation() {
		System.out.println("Decorator1:before operation!");
		sourcable.operation();
		System.out.println("Decorator1:after operation!");
	}

}
