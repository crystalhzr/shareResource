<%@page import="com.jaovo.msg.model.Resource"%>
<%@page import="com.jaovo.msg.dao.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page contentType="text/html; charset=gb2312"%>

<html>
<head>
</head>
<body>
<%
    //���տͻ��˴��ݹ����Ĳ���
    String resname =request.getParameter("textValue");
    System.out.print(resname);
    ResourceDAOImpl resDao = new ResourceDAOImpl();
	Resource resource=resDao.loadByResname(resname);
	request.setAttribute("res", resource);
	request.getRequestDispatcher("/resDetail.jsp").forward(request, response);
%>
</body>
</html>