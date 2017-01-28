package com.Smileyes.service.impl;

import java.util.List;

import com.Smileyes.Exception.ConExitException;
import com.Smileyes.dao.Dao;
import com.Smileyes.dao.impl.DaoImpl;
import com.Smileyes.entity.Contact;
import com.Smileyes.service.Service;

public class ContactService implements Service {

	public void addContact(Contact c) throws ConExitException {
		Dao dao = new DaoImpl();
		if (!dao.checkContact(c)) {
			throw new ConExitException("重复");
		}
		dao.findContact(c.getId());
		dao.addContact(c);
	}

	public void removeContact(String id) {
		Dao dao = new DaoImpl();
		dao.removeContact(id);
	}

	public void changeContact(Contact c) {
		Dao dao = new DaoImpl();
		dao.changeContact(c);
	}

	public Contact findContact(String id) {
		Dao dao = new DaoImpl();
		Contact c = dao.findContact(id);
		return c;
	}

	public List<Contact> showAll() {
		Dao dao = new DaoImpl();
		List list = dao.showAll();
		return list;
	}

}
