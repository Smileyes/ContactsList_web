package com.Smileyes.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Before;
import org.junit.Test;

import com.Smileyes.entity.Contact;

public class TestDaoImpl {
	// 添加联系人
	/*@Test*/
	public void addContact() {
		SAXReader reader = new SAXReader();
		Document doc = null;
		XMLWriter writer = null;
		try {
			doc = reader.read("F:/data/contactsList.xml");
			writer = new XMLWriter(new FileOutputStream(
					"F:/data/contactsList.xml"),
					OutputFormat.createPrettyPrint());
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Contact c = new Contact("1", "张三丰", "男", "1111111111", "1111@Gmail.com");
		Element rootEle = doc.getRootElement();
		Element contactEle = rootEle.addElement("contact");
		contactEle.addAttribute("id", c.getId());
		contactEle.addElement("name").setText(c.getName());
		contactEle.addElement("gender").setText(c.getGender());
		contactEle.addElement("number").setText(c.getNumber());
		contactEle.addElement("email").setText(c.getEmail());
		try {
			writer.write(doc);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 删除联系人
	/*@Test*/
	public void removeContact() {
		String id="1";
		SAXReader reader = new SAXReader();
		Document doc = null;
		XMLWriter writer = null;
		try {
			doc = reader.read("F:/data/contactsList.xml");
			writer = new XMLWriter(new FileOutputStream(
					"F:/data/contactsList.xml"),
					OutputFormat.createPrettyPrint());
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Element targetEle = (Element) doc.selectSingleNode("//contact[@id="
				+ id + "]");
		targetEle.detach();
		try {
			writer.write(doc);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*@Test*/
	public void changeContact() {
		Contact c = new Contact("1", "张三丰", "男", "22222222222",
				"22222@Foxmail.com");
		SAXReader reader = new SAXReader();
		Document doc = null;
		XMLWriter writer = null;
		try {
			doc = reader.read("F:/data/contactsList.xml");
			writer = new XMLWriter(new FileOutputStream(
					"F:/data/contactsList.xml"),
					OutputFormat.createPrettyPrint());
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Element targetEle = (Element) doc.selectSingleNode("//contact[@id="
				+ c.getId() + "]");
		targetEle.element("name").setText(c.getName());
		targetEle.element("gender").setText(c.getGender());
		targetEle.element("number").setText(c.getNumber());
		targetEle.element("email").setText(c.getEmail());
		try {
			writer.write(doc);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 搜寻联系人
	/*@Test*/
	public void findContact() {
		String id="1";
		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			doc = reader.read("F:/data/contactsList.xml");
		} catch (DocumentException e) {
			e.printStackTrace();
		} 
		Element targetEle = (Element) doc.selectSingleNode("//contact[@id="
				+ id + "]");
		if (targetEle != null) {
			String targetEleName = targetEle.elementTextTrim("name");
			String targetEleGender = targetEle.elementTextTrim("gender");
			String targetEleNumber = targetEle.elementTextTrim("number");
			String targetEleEmail = targetEle.elementTextTrim("email");
			Contact c= new Contact(id, targetEleName, targetEleGender,
					targetEleNumber, targetEleEmail);
			System.out.println(c);
		} 
	}

	// 显示所有联系人
	@Test
	public void showAll() {
		File file = new File("F:/data/contactsList.xml");
		if (!file.exists()) {
			this.prepare();
		}
		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			doc = reader.read("F:/data/contactsList.xml");
		} catch (DocumentException e) {
			e.printStackTrace();
		} 
		Element rootEle = doc.getRootElement();
		List<Contact> list = new ArrayList<Contact>();
		List<Element> contactsEle = rootEle.elements();
		for (Element ct : contactsEle) {
			String ctId = ct.attributeValue("id");
			String ctName = ct.elementTextTrim("name");
			String ctGender = ct.elementTextTrim("gender");
			String ctNumber = ct.elementTextTrim("number");
			String ctEmail = ct.elementTextTrim("email");
			list.add(new Contact(ctId, ctName, ctGender, ctNumber, ctEmail));
		}
		System.out.println(list);
	}

	//当文件不存在时，新建文件
	/*@Before*/
	public void prepare() {
		SAXReader reader = new SAXReader();
		Document doc = null;
		XMLWriter writer = null;
		try {
			doc = DocumentHelper.createDocument();
			writer = new XMLWriter(new FileOutputStream(
					"F:/data/contactsList.xml"),
					OutputFormat.createPrettyPrint());
			doc.addElement("contactsList");
			writer.write(doc);
			writer.flush();
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