package org.test;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfWriter;

public class Test {
	public static void main(String[] args) {
		Rectangle pageSize = new Rectangle(144, 720);
		pageSize.setBackgroundColor(new Color(0xFF, 0xFF, 0xDE));
		Document document = new Document(pageSize);
//		Document document = new Document();
		try {
			PdfWriter.getInstance(document,new FileOutputStream("Chap0101.pdf"));
			document.open();
			document.add(new Paragraph("Hello World"));
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		document.close();
	}
}
