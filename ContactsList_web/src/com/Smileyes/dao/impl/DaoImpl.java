/*
 * 实现建立一个本地的XML文件，并建立好根标签<contactsList> 使用直接路径
 */
package com.Smileyes.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.Smileyes.dao.Dao;
import com.Smileyes.entity.Contact;
import com.Smileyes.util.XMLUtil;

public class DaoImpl implements Dao {
	// 添加联系人
	public void addContact(Contact c) {
		XMLUtil util = new XMLUtil();
		Document doc = util.getDocument();
		Element rootEle = doc.getRootElement();
		Element contactEle = rootEle.addElement("contact");
		contactEle.addAttribute("id", c.getId());
		contactEle.addElement("name").setText(c.getName());
		contactEle.addElement("gender").setText(c.getGender());
		contactEle.addElement("number").setText(c.getNumber());
		contactEle.addElement("email").setText(c.getEmail());
		util.write2xml(doc);
	}

	// 删除联系人
	public void removeContact(String id) {
		XMLUtil util = new XMLUtil();
		Document doc = util.getDocument();
		Element targetEle = (Element) doc.selectSingleNode("//contact[@id="
				+ id + "]");
		targetEle.detach();
		util.write2xml(doc);
	}

	public void changeContact(Contact c) {
		XMLUtil util = new XMLUtil();
		Document doc = util.getDocument();
		Element targetEle = (Element) doc.selectSingleNode("//contact[@id="
				+ c.getId() + "]");
		targetEle.element("name").setText(c.getName());
		targetEle.element("gender").setText(c.getGender());
		targetEle.element("number").setText(c.getNumber());
		targetEle.element("email").setText(c.getEmail());
		util.write2xml(doc);
	}

	// 搜寻联系人
	public Contact findContact(String id) {
		XMLUtil util = new XMLUtil();
		Document doc = util.getDocument();
		Element targetEle = (Element) doc.selectSingleNode("//contact[@id="
				+ id + "]");
		if (targetEle != null) {
			String targetEleName = targetEle.elementTextTrim("name");
			String targetEleGender = targetEle.elementTextTrim("gender");
			String targetEleNumber = targetEle.elementTextTrim("number");
			String targetEleEmail = targetEle.elementTextTrim("email");
			return new Contact(id, targetEleName, targetEleGender,
					targetEleNumber, targetEleEmail);
		} else {
			return null;
		}
	}

	// 显示所有联系人
	public List<Contact> showAll() {
		File file = new File("F:/data/contactsList.xml");
		if (!file.exists()) {
			this.prepare();
		}
		XMLUtil util = new XMLUtil();
		Document doc = util.getDocument();
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
		return list;
	}

	private static void prepare() {
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

	public boolean checkContact(Contact c) {
		XMLUtil util = new XMLUtil();
		Document doc = util.getDocument();
		Node n1 = doc.selectSingleNode("//contact[@id=" + c.getId() + "]");
		Node n2 = doc.selectSingleNode("//contact/name[text()='" + c.getName()
				+ "']");
		if (n1 == null && n2 == null) {
			return true;
		}
		return false;
	}
}
