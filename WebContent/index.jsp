<%@ page language="java"
	import="java.util.*,com.hh.dao.*,com.hh.dao.impl.*,com.hh.entity.*"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String htmlData = request.getParameter("message")!=null ? request.getParameter("message") : "";
String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>留言板</title>
<script type="text/javascript" src="<%=path%>/kindeditor/kindeditor.js"></script>
<script type="text/javascript">
    
	    KE.show({
			id : 'test',
			imageUploadJson : '<%=path%>/kindeditor/upload_json.jsp',
			fileManagerJson : '<%=path%>	/kindeditor/file_manager_json.jsp',
		allowFileManager : true,
		afterCreate : function(id) {
			KE.event.ctrl(document, 13, function() {
				KE.util.setData(id);
				document.forms['example'].submit();
			});
			KE.event.ctrl(KE.g[id].iframeDoc, 13, function() {
				KE.util.setData(id);
				document.forms['example'].submit();
			});
		}
	});
</script>
<style type="text/css">
table {
	border-collapse: collapse;
	border-spacing: 0;
	padd: expression(this.cellPadding =     0);
}
</style>
</head>
<body>
	<h2 align="center">留言板</h2>
	<%
		MessageDao messageDao = new MessageDaoImpl();
		List<Messages> list = messageDao.getAll();
		for (Messages m : list) {
	%>
	<table align="center" border="1" borderColor="#CCCCFF" width="1150"
		style="border:">
		<tr bgColor="#CCCC99">
			<td><font color="white">作者:<%=m.getAuthor()%>
					发表时间:<fmt:formatDate value="<%=m.getPostTime() %>" pattern="yyyy-MM-dd HH:mm:ss" /> </font></td>
		</tr>
		<tr bgColor="#EFFEFE">
			<td>内容:<%=m.getMessage()%></td>
		</tr>
	</table>
	<p></p>
	<%
		}
	%>
</body>
<FORM METHOD=POST ACTION="doAdd.jsp">
	<TABLE align="center" width="1150" style="border:">
		<TR>
			<TD>作者:</TD>
			<TD><INPUT TYPE="text" NAME="author">
			</TD>
		</TR>
		<TR>
			<TD>留言:</TD>
			<TD><textarea id="test" name="message" cols="100" rows="8"
					style="width:700px;height:200px;visibility:hidden"></textarea></TD>
		</TR>
		<TR>
			<TD><INPUT TYPE="submit" value="提交">
			</TD>
			<TD><INPUT TYPE="reset" value="重置">
			</TD>
		</TR>
	</TABLE>
</FORM>
</html>