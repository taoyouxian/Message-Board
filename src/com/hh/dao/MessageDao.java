package com.hh.dao;

import java.util.List;

import com.hh.entity.Messages;

/**
 * ��ѯ���Ե� �ӿڱ�׼
 * 
 * @author Tao
 * @version 1.0
 * 
 */
public interface MessageDao {
	// ��ѯ���е���Ϣ
	public List<Messages> getAll();

	// �����Ϣ
	public int addMessage(Messages m);
}