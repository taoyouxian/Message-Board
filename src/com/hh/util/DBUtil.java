package com.hh.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 连接数据库的核心类
 * 
 * @author Tao
 * @version 1.0 2015-01-04
 */
public class DBUtil {

	/**
	 * jdbc连接信息
	 */
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/tao";
	public static final String USER = "root";
	public static final String PWD = "root";

	private Connection conn = null; // 数据库连接对象
	private PreparedStatement psmt = null; // 预执行对象
	public ResultSet rs = null; // 结果集

	/**
	 * 获取连接
	 */
	public void getConnection() {
		try {
			// 加载驱动
			Class.forName(DRIVER);
			// 获取连接
			conn = DriverManager.getConnection(URL, USER, PWD);
			System.out.println(conn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询的公共方法
	 * 
	 * @param sql
	 *            执行的sql语句
	 * @param arr
	 *            sql的执行条件
	 * @return 结果集
	 */
	public ResultSet getQuery(String sql, String[] arr) {

		getConnection();

		try {
			psmt = conn.prepareStatement(sql); // select * from ta where ta.a =?
												// and ta.b =?

			if (arr != null && arr.length > 0) {
				for (int i = 0; i < arr.length; i++) {
					psmt.setString(i + 1, arr[i]);
				}
			}
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	/**
	 * 数据变更的方法（增、删、改）
	 * 
	 * @param sql
	 *            执行的sql
	 * @param arr
	 *            条件组成的数组
	 * @return
	 */
	public int getUpdate(String sql, String[] arr) {
		int result = 0;
		getConnection();

		try {
			psmt = conn.prepareStatement(sql);
			if (arr != null && arr.length > 0) {
				for (int i = 0; i < arr.length; i++) {
					psmt.setString(i + 1, arr[i]);
				}
			}
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 关闭
	 */
	public void CloseAll() {
		try {
			if (rs != null) {
				rs.close();
			}

			if (psmt != null) {
				psmt.close();
			}

			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new DBUtil().getConnection();
	}
}