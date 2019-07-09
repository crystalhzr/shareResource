<%@page import="com.jaovo.msg.Util.UserException"%>
<%@page import="com.jaovo.msg.dao.UserDaoImpl"%>
<%@page import="com.jaovo.msg.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户添加页面</title>
</head>
<body>
<%
    //接收客户端传递过来的参数
    String username = request.getParameter("username");
    String password = request.getParameter("password").trim();
    String confirm = request.getParameter("confirmword").trim();
    String email = request.getParameter("email");
    String school = request.getParameter("school");
    String college = request.getParameter("college");
    String profession = request.getParameter("profession");
    
    if(username == null || "".equals(username.trim())||password == null || "".equals(password.trim())){
%>
    <script type="text/javascript" language="javascript">
        alert("用户名和密码不能为空!");
        window.document.location.href="register.html";
    </script>
<%
    }
    if(!password.equals(confirm)){
    	%>
    	    <script type="text/javascript" language="javascript">
    	        alert("两次密码输入不一致");
    	        window.document.location.href="register.html";
    	    </script>
    	<%
    	    }
    	%>
%>

<%
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    user.setEmail(email);
    user.school=school;
    user.college=college;
    user.profession=profession;
    
    UserDaoImpl userDao = new UserDaoImpl();
    try{
    userDao.add(user);
%>
    <script type="text/javascript" language="javascript">
        alert("注册成功!");
        window.document.location.href="login.html";
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