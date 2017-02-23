/*
 * Dao接口用与定义本项目相关工具方法的实现对象
 */
package com.Smileyes.dao;

import java.util.List;

import com.Smileyes.entity.Contact;

public interface Dao {
	// 用于添加联系人
	public void addContact(Contact c);

	// 用于移除联系人
	public void removeContact(String id);

	// 用于更改联系人
	public void changeContact(Contact c);

	// 用于查询联系人
	public Contact findContact(String id);

	// 用于显示所有联系人
	public List<Contact> showAll();

	// 检查该联系人否存在
	public boolean checkContact(Contact c);
}
