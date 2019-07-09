<%@page import="com.jaovo.msg.Util.UserException"%>
<%@page import="com.jaovo.msg.dao.UserDaoImpl"%>
<%@page import="com.jaovo.msg.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户身份验证</title>
</head>
<body>
<%
    //接收客户端传递过来的参数
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    if(username == null || "".equals(username.trim())||password == null || "".equals(password.trim()))
    {
        request.setAttribute("error", "用户名和密码不能为空！");
%>
    <jsp:forward page="Login.jsp"></jsp:forward>
<%
    }
%>
<%
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    UserDaoImpl userDao = new UserDaoImpl();
    try
    {
        if(userDao.load(username)==null)
        {
            throw new UserException();
        }
        if(userDao.check(user)==true)
        {
        	//创建session对象
            HttpSession userSession = request.getSession();
            //把用户数据保存在session域对象中
            userSession.setAttribute("loginUser", user);
%>
    <script type="text/javascript" language="javascript">
        alert("登录成功!");
        window.document.location.href="index.html";
    </script>  
<%
        }
        else
        {
%>
    <script type="text/javascript" language="javascript">
        alert("密码错误");
        window.document.location.href="login.jsp";
    </script>  
<%
        }
    }
    catch(UserException e)
    {
%>
    <script type="text/javascript" language="javascript">
        alert("该用户名不存在!");
        window.document.location.href="login.jsp";
    </script> 
    <%
    }
    %>
    </body>
</html>