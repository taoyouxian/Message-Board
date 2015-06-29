package com.hh.dao;

import java.util.List;

import com.hh.entity.Messages;

/**
 * 查询留言的 接口标准
 * 
 * @author Tao
 * @version 1.0
 * 
 */
public interface MessageDao {
	// 查询所有的消息
	public List<Messages> getAll();

	// 添加消息
	public int addMessage(Messages m);
}