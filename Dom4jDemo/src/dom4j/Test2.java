package dom4j;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;

/**
 * 有命名空间的xml解析
 * @author xuyuji
 *
 */
public class Test2 {
	public static void main(String[] args) throws Exception {
		play5();
	}
	/**
	 * test2.xml中有3个b节点，2个有命名空间
	 * 此方法拿没有命名空间的b
	 * @throws DocumentException
	 */
	public static void play1() throws DocumentException{
		SAXReader reader = new SAXReader();
		Document document = reader.read(Test2.class.getResourceAsStream("/test2.xml"));
		
		Element root = document.getRootElement();
		List<Element> list = root.selectNodes("//b");
		for(Element e : list){
			System.out.println(e.asXML());
			System.out.println();
		}
	}
	/**
	 * 设置xpath的命名空间取有命名空间的b
	 * xPath.setNamespaceURIs()方法接受一对映射，map如若有多条，则取最新的。
	 * ps:b下的节点继承命名空间。
	 * @throws DocumentException
	 */
	public static void play2() throws DocumentException{
		SAXReader reader = new SAXReader();
		Document document = reader.read(Test2.class.getResourceAsStream("/test2.xml"));
		
		XPath xPath = document.createXPath("//x:b");
		Map nameSpaceMap = new HashMap();
		//分别表示三个b
		nameSpaceMap.put("x", "www.b1.com");
//		nameSpaceMap.put("x", "www.b2.com");
//		nameSpaceMap.put("x", "");
		xPath.setNamespaceURIs(nameSpaceMap);
		List<Element> list = xPath.selectNodes(document);
		for(Element e : list){
			System.out.println(e.asXML());
			System.out.println();
		}
	}
	/**
	 * 设置DocumentFactory的命名空间
	 * @throws DocumentException
	 */
	public static void play3() throws DocumentException{
		SAXReader reader = new SAXReader();
		reader.getDocumentFactory().setXPathNamespaceURIs(Collections.singletonMap("xx", "www.b1.com"));
		Document document = reader.read(Test2.class.getResourceAsStream("/test2.xml"));
		List<Element> list = document.selectNodes("//xx:b");
		for(Element e : list){
			System.out.println(e.asXML());
			System.out.println();
		}
		List<Element> list1 = document.selectNodes("//xx:c");
		for(Element e : list1){
			System.out.println(e.asXML());
			System.out.println();
		}
	}
	/**
	 * 使用xpath语法取命名空间节点
	 * “//*”表示所有节点,local-name()返回当前节点名称,namespace-uri()返回当前节点命名空间。
	 * @throws DocumentException
	 */
	public static void play4() throws DocumentException{
		SAXReader reader = new SAXReader();
		Document document = reader.read(Test2.class.getResourceAsStream("/test2.xml"));
		List<Element> list = document.selectNodes("//*[local-name()='b' and namespace-uri()='www.b1.com']");
		for(Element e : list){
			System.out.println(e.asXML());
			System.out.println();
		}
		List<Element> list1 = document.selectNodes("//*[local-name()='c' and namespace-uri()='www.b2.com']");
		for(Element e : list1){
			System.out.println(e.asXML());
			System.out.println();
		}
	}
	/**
	 * Element节点调用addNamespace()方法添加命名空间
	 * @throws DocumentException
	 */
	public static void play5() throws DocumentException{
		String xmlStr = "<a xmlns='dom4j/test2.play5'>" +
						"	<b>" +
						"		<c>c1</c>" +
						"		<d>d1</d>" +
						"	</b>" +
						"	<b>" +
						"		<c>c2</c>" +
						"		<d>d2</d>" +
						"	</b>" +
						"</a>";
		Document document = DocumentHelper.parseText(xmlStr);
		Element root = document.getRootElement();
		root.addNamespace("x", "dom4j/test2.play5");
		List<Element> list = root.selectNodes("//x:c");
		for(Element e : list){
			System.out.println(e.asXML());
		}
	}
}
