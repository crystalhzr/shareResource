<%@page import="com.jaovo.msg.Util.UserException"%>
<%@page import="com.jaovo.msg.dao.MessageDaoImpl"%>
<%@page import="com.jaovo.msg.model.Message"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户添加页面</title>
</head>
<body>
<%
    //接收客户端传递过来的参数
    String msgPoster = request.getParameter("msgPoster");
    String msgTitle = request.getParameter("msgTitle").trim();
    String msgContent = request.getParameter("msgContent").trim();
    String msgDate = request.getParameter("msgDate");

    Message msg = new Message();
    msg.setmsgPoster(msgPoster);
    msg.setmsgTitle(msgTitle);
    msg.setmsgDate(msgDate);
    msg.setmsgContent(msgContent);
    
    MessageDaoImpl msgDao = new MessageDaoImpl();
    try{
    	msgDao.add(msg);
%>
    <script type="text/javascript" language="javascript">
        alert("发布成功!");
        window.document.location.href="http://localhost:8080/webdemo/ShowMsgList";
    </script>   
<%
    }catch(UserException e){
%>
    <h2 style="color:red ; font-size:50px">发生错误 : <%=e.getMessage() %></h2>
    <%
    }
    %>
    </body>
</html>