package pattern.decorator;

public class DecoratorDemo {
	public static void main(String[] args) {
		Sourcable sourcable = new Source();
		sourcable.operation();
		System.out.println("====================");
		sourcable = new Decorator3(new Decorator2(new Decorator1(new Source())));
		sourcable.operation();
		System.out.println("====================");
		sourcable = new Decorator1(new Decorator3(new Decorator2(new Source())));
		sourcable.operation();
	}
}
