package pattern.decorator;

public class Decorator2 implements Sourcable {

	Sourcable sourcable;
	
	public Decorator2(Sourcable sourcable) {
		this.sourcable = sourcable;
	}
	
	@Override
	public void operation() {
		System.out.println("Decorator2:before operation!");
		sourcable.operation();
		System.out.println("Decorator2:after operation!");
	}

}
