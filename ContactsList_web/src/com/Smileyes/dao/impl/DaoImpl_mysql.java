package com.Smileyes.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Smileyes.dao.Dao;
import com.Smileyes.entity.Contact;
import com.Smileyes.util.JdbcUtil;

public class DaoImpl_mysql implements Dao {

	public void addContact(Contact c) {
		Connection conn = null;
		PreparedStatement stmt = null;
		// 编写预编译语言
		String sql = "INSERT INTO contactslist(name,gender,number,email)VALUES(?,?,?,?);";
		// 获取连接，提交sql语句
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareCall(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		// 设置参数
		try {
			stmt.setString(1, c.getName());
			stmt.setString(2, c.getGender());
			stmt.setString(3, c.getNumber());
			stmt.setString(4, c.getEmail());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 提交参数，执行sql语句
		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		// 关闭stmt和conn
		JdbcUtil.close(conn, stmt);
	}

	public void removeContact(String id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = JdbcUtil.getConnection();
		String sql = "DELETE FROM contactslist WHERE id=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcUtil.close(conn, stmt);
	}

	public void changeContact(Contact c) {
		System.out.println(c);
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = JdbcUtil.getConnection();
		String sql = "UPDATE contactslist SET name=?,gender=?,number=?,email=? WHERE id=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, c.getName());
			stmt.setString(2, c.getGender());
			stmt.setString(3, c.getNumber());
			stmt.setString(4, c.getEmail());
			stmt.setString(5, c.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcUtil.close(conn, stmt);
	}

	public Contact findContact(String id) {
		Contact con = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = JdbcUtil.getConnection();
		String sql = "SELECT * from contactslist WHERE id=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				con = new Contact(rs.getString("id"), rs.getString("name"),
						rs.getString("gender"), rs.getString("number"),
						rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcUtil.close(conn, stmt, rs);
		return con;
	}

	public List<Contact> showAll() {
		List<Contact> list = new ArrayList<Contact>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// 编写预编译语言
		String sql = "SELECT * FROM contactslist";
		// 获取连接，提交sql语句
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		// 执行sql语句
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		// 获取查询结果
		try {
			while (rs.next()) {
				list.add(new Contact(rs.getString("id"), rs.getString("name"),
						rs.getString("gender"), rs.getString("number"), rs
								.getString("email")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 关闭stmt和conn
		JdbcUtil.close(conn, stmt, rs);
		return list;
	}

	// 查询是否已经存在该联系人,不存在返回true
	public boolean checkContact(Contact c) {
		boolean exit = true;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = JdbcUtil.getConnection();
		String sql = "SELECT * from contactslist WHERE name=? AND gender=? AND number=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, c.getName());
			stmt.setString(2, c.getGender());
			stmt.setString(3, c.getNumber());
			rs = stmt.executeQuery();
			if (rs.next()) {
				exit = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcUtil.close(conn, stmt, rs);
		return exit;
	}

}
