package dom4j;
import java.io.File;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.VisitorSupport;
import org.dom4j.io.SAXReader;


public class Test {
	public static void main(String[] args) throws Exception {
		test3();
	}
	public static void test1() throws Exception{
		SAXReader reader = new SAXReader();
		String path = Test.class.getClassLoader().getResource(".").toURI().getPath();
		Document document = reader.read(new File(path+"test.xml"));
		List list = document.selectNodes("//action");
		Iterator it = list.iterator();
		while(it.hasNext()){
			Element e = (Element) it.next();
			System.out.println(e.getName());
		}
		System.out.println("=====================");
		Element root = document.getRootElement();
		root.accept(new VisitorSupport(){
			@Override
			public void visit(Element node) {
				System.out.println(node.getName());
//				super.visit(node);
			}
		});
	}
	public static void test2() throws Exception{
		SAXReader reader = new SAXReader();
		String path = Test.class.getClassLoader().getResource(".").toURI().getPath();
		Document document = reader.read(new File(path+"test.xml"));
		System.out.println(document.asXML());
		System.out.println("==========================");
		Element root = document.getRootElement();
		root.addElement("x1");
		root.addElement("x2");
		root.element("x2").addElement("x2_1");
		root.element("x2").element("x2_1").setText("x2_1");
		root.element("x2").addElement("x2_2");
		root.addElement("x3");
		root.addElement("x4");
//		root.remove(root.element("x2"));
//		root.element("x2").remove(root.element("x2").element("x2_1"));
		System.out.println(document.asXML());
		Element e21 = root.element("x2").element("x2_1");
		System.out.println("=============================");
		System.out.println(document.asXML());
		e21.getParent().remove(e21);
		System.out.println("=============================");
		System.out.println(document.asXML());
	}
	public static void test3() throws DocumentException, URISyntaxException{
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(Test.class.getClassLoader().getResource(".").toURI().getPath() + "/test.xml"));
		System.out.println(document.asXML());
		Element root = document.getRootElement();
		List<Element> list_son = root.selectNodes("//son");
		Element son = list_son.get(0);
		//.表示当前位置..表示父节点,//action这里会找到2个节点,.//action则只会找到son节点下面的action
		List<Element> list_action = son.selectNodes(".//action");
		System.out.println(list_action.size());
		System.out.println(list_action.get(0).getText());
	}
}
