package com.Smileyes.service;

import java.util.List;

import com.Smileyes.Exception.ConExitException;
import com.Smileyes.entity.Contact;

public interface Service {
	public void addContact(Contact c) throws ConExitException;

	// 用于移除联系人
	public void removeContact(String id);

	// 用于更改联系人
	public void changeContact(Contact c);

	// 用于查询联系人
	public Contact findContact(String id);

	// 用于显示所有联系人
	public List<Contact> showAll();
}
