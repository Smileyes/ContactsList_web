package com.Smileyes.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.Smileyes.dao.Dao;
import com.Smileyes.entity.Contact;
import com.Smileyes.util.JdbcUtil;

public class DaoImpl_mysql implements Dao {
	QueryRunner qr = new QueryRunner();
	Connection conn = null;

	public void addContact(Contact c) {
		// 获取连接
		conn = JdbcUtil.getConnection();
		// 编写预编译语言
		String sql = "INSERT INTO contactslist(name,gender,number,email)VALUES(?,?,?,?);";
		// 提交sql语句
		try {
			qr.update(conn, sql, c.getName(), c.getGender(), c.getNumber(),
					c.getEmail());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
	}

	public void removeContact(String id) {
		conn = JdbcUtil.getConnection();
		String sql = "DELETE FROM contactslist WHERE id=?";
		try {
			qr.update(conn, sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbUtils.closeQuietly(conn);

	}

	public void changeContact(Contact c) {
		conn = JdbcUtil.getConnection();
		String sql = "UPDATE contactslist SET name=?,gender=?,number=?,email=? WHERE id=?";
		try {
			qr.update(conn, sql, c.getName(), c.getGender(), c.getNumber(),
					c.getEmail(), c.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbUtils.closeQuietly(conn);
	}

	public Contact findContact(String id) {
		Contact con = null;
		conn = JdbcUtil.getConnection();
		String sql = "SELECT * from contactslist WHERE id=?";
		try {
			con = qr.query(conn, sql, new BeanHandler<Contact>(Contact.class),
					id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return con;
	}

	public List<Contact> showAll() {
		List<Contact> list = new ArrayList<Contact>();
		// 编写预编译语言
		String sql = "SELECT * FROM contactslist";
		// 获取连接，提交sql语句
		conn = JdbcUtil.getConnection();
		try {
			list = qr.query(conn, sql, new BeanListHandler<Contact>(
					Contact.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return list;
	}

	// 查询是否已经存在该联系人,不存在返回true
	public boolean checkContact(Contact c) {
		boolean exist = true;
		conn = JdbcUtil.getConnection();
		String sql = "SELECT * from contactslist WHERE name=? AND gender=? AND number=?";
		Contact con = null;
		try {
			con = qr.query(conn, sql, new BeanHandler<Contact>(Contact.class),
					c.getName(), c.getGender(), c.getEmail());
			if (con != null) {
				exist = false;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return exist;
	}

}
