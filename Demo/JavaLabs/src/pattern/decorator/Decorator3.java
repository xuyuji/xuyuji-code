package pattern.decorator;

public class Decorator3 implements Sourcable {

	Sourcable sourcable;
	
	public Decorator3(Sourcable sourcable) {
		this.sourcable = sourcable;
	}
	
	@Override
	public void operation() {
		System.out.println("Decorator3:before operation!");
		sourcable.operation();
		System.out.println("Decorator3:after operation!");
	}

}
