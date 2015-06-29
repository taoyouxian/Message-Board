package com.hh.dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hh.dao.MessageDao;
import com.hh.entity.Messages;
import com.hh.util.DBUtil;

/**
 * 业务逻辑类
 * 
 * @author Tao
 * @version 1.0 2015-01-04
 */
public class MessageDaoImpl extends DBUtil implements MessageDao {

	@Override
	public List<Messages> getAll() {

		List<Messages> list = new ArrayList<Messages>();

		String sql = "select * from messages";
		rs = this.getQuery(sql, null);
		try {
			while (rs.next()) {
				Messages m = new Messages();
				m.setMid(rs.getInt("mid"));
				m.setAuthor(rs.getString("author"));
				m.setMessage(rs.getString("message"));
				m.setPostTime(rs.getTimestamp("postTime"));// rs.getTime是获取时间，原来是getDate获取yy-MM-dd
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int addMessage(Messages m) {
		String sql = "insert into messages(message,author,postTime) values(?,?,?)";
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return this.getUpdate(sql, new String[] { m.getMessage(),
				m.getAuthor(), time.format(new Date()) });
	}

}