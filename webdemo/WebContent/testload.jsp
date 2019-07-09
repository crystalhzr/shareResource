<%@page import="com.jaovo.msg.model.Resource"%>
<%@page import="com.jaovo.msg.dao.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h1>hello</h1>
<%
    //接收客户端传递过来的参数
    String resname =request.getParameter("textValue");
    System.out.print(resname);
    ResourceDAOImpl resDao = new ResourceDAOImpl();
	Resource resource=resDao.loadByResname(resname);
	request.setAttribute("res", resource);
%>
</body>
</html>