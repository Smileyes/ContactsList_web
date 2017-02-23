/*
 *实体对象contact的类，本项目唯一的实体类 
 */
package com.Smileyes.entity;

public class Contact {
	private String id;
	private String name;
	private String gender;
	private String number;
	private String email;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Contact(String id, String name, String gender, String number,
			String email) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.number = number;
		this.email = email;
	}

	public Contact() {
	}

	public int hashCode() {
		return id.hashCode();
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else {
			Contact c = (Contact) obj;
			if (id.equals(c.id)) {
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public String toString() {
		return "id="+id+"name="+name+"gender="+gender+"number="+number+"email="+email;
	}
}
