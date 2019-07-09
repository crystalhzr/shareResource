<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
	pageEncoding="UTF-8"%>
<%@page import="com.jaovo.msg.dao.*" %>
<%@page import="com.jaovo.msg.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="text-align: center; margin-top: 140px">
		<h1>请留言</h1>
		<form action="addMsg.jsp" method="post">
			<table style="margin-left: 37%" border="1">
				<caption>填写留言信息</caption>
				<tr>
					<td>发帖人</td>
					<td><input type="text" name="msgPoster" /></td>
				</tr>
				<tr>
					<td>标题</td>
					<td><input type="text" name="msgTitle" /></td>
				</tr>
				<tr>
					<td>发帖时间</td>
					<td><input type="text" name="msgDate" /></td>
				</tr>				
				<tr>
					<td>内容</td>
					<td><textarea name="msgContent" rows="5" cols="35"></textarea></td>
				</tr>
			</table>
			<input type="submit" value="提交" /> <input type="reset" value="重置" />
		</form>
		<a href="msgList.jsp">返回留言板界面</a>
	</div>

</body>
</html>