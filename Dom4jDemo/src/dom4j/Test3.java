package dom4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 修改xml
 * ps:在eclipse下的时候代码修改的是bin目录下的文件,src下的文件不会变
 * @author xuyuji
 *
 */
public class Test3 {
	public static void main(String[] args) throws IOException, DocumentException, URISyntaxException {
		String path = Test3.class.getClassLoader().getResource(".").getPath();
		
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(path + "/test3.xml"));
		Element root = document.getRootElement();
		root.addElement("b");
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new FileWriter(new File(path + "/test3.xml")));
		writer.write(document);
		writer.close();
	}
}
