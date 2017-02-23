package com.Smileyes.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XMLUtil {

	public Document getDocument() {
		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			doc = reader.read("F:/data/contactsList.xml");
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return doc;
	}

	public void write2xml(Document doc) {
		XMLWriter writer = null;
		try {
			writer = new XMLWriter(new FileOutputStream(
					"F:/data/contactsList.xml"),
					OutputFormat.createPrettyPrint());
			writer.write(doc);
			writer.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
