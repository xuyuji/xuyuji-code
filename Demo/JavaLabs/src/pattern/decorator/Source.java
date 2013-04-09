package pattern.decorator;

public class Source implements Sourcable{

	@Override
	public void operation() {
		System.out.println("原始类方法");
	}

}
