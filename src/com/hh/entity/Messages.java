package com.hh.entity;

import java.util.Date;

/**
 * ʵ����� - ��Ӧ���ݿ��messages��
 * 
 * @author Tao
 * @version 1.0 2015-01-04
 * 
 */
public class Messages {

	private int mid;
	private String message;
	private String author;
	private Date postTime;

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
}