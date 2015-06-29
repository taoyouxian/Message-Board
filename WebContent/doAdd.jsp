<%@page import="com.hh.dao.MessageDao"%>
<%@page import="com.hh.entity.Messages"%>
<%@ page language="java" import="java.util.*,com.hh.dao.impl.*"
	pageEncoding="utf-8"%>
<%
	String author = new String(request.getParameter("author").getBytes("ISO-8859-1"), "utf-8");
	String message = new String(request.getParameter("message").getBytes("ISO-8859-1"), "utf-8");
	System.out.println(author + "===========" + message);
	Messages m = new Messages();
	m.setAuthor(author);
	m.setMessage(message);

	MessageDao mDao = new MessageDaoImpl();
	int result = mDao.addMessage(m);
	if (result > 0) {
		response.sendRedirect("index.jsp");
	}
%>
