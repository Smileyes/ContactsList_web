package com.Smileyes.service.impl;

import java.util.List;

import com.Smileyes.Exception.ConExitException;
import com.Smileyes.dao.Dao;
import com.Smileyes.dao.impl.DaoImpl_mysql;
import com.Smileyes.entity.Contact;
import com.Smileyes.service.Service;

public class ContactService implements Service {

	public void addContact(Contact c) throws ConExitException {
		Dao dao = new DaoImpl_mysql();
		if (!dao.checkContact(c)) {
			throw new ConExitException("重复");
		}
		dao.findContact(c.getId());
		dao.addContact(c);
	}

	public void removeContact(String id) {
		Dao dao = new DaoImpl_mysql();
		dao.removeContact(id);
	}

	public void changeContact(Contact c) {
		Dao dao = new DaoImpl_mysql();
		dao.changeContact(c);
	}

	public Contact findContact(String id) {
		Dao dao = new DaoImpl_mysql();
		Contact c = dao.findContact(id);
		return c;
	}

	public List<Contact> showAll() {
		Dao dao = new DaoImpl_mysql();
		List list = dao.showAll();
		return list;
	}

}
