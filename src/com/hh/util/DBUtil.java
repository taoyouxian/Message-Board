package com.hh.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * �������ݿ�ĺ�����
 * 
 * @author Tao
 * @version 1.0 2015-01-04
 */
public class DBUtil {

	/**
	 * jdbc������Ϣ
	 */
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/tao";
	public static final String USER = "root";
	public static final String PWD = "root";

	private Connection conn = null; // ���ݿ����Ӷ���
	private PreparedStatement psmt = null; // Ԥִ�ж���
	public ResultSet rs = null; // �����

	/**
	 * ��ȡ����
	 */
	public void getConnection() {
		try {
			// ��������
			Class.forName(DRIVER);
			// ��ȡ����
			conn = DriverManager.getConnection(URL, USER, PWD);
			System.out.println(conn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ѯ�Ĺ�������
	 * 
	 * @param sql
	 *            ִ�е�sql���
	 * @param arr
	 *            sql��ִ������
	 * @return �����
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
	 * ���ݱ���ķ���������ɾ���ģ�
	 * 
	 * @param sql
	 *            ִ�е�sql
	 * @param arr
	 *            ������ɵ�����
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
	 * �ر�
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