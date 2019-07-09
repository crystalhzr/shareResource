<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎来到登录界面</title>
<link href="css/log.css" rel="stylesheet">
</head>
<body  style="background:url(images/logbg.jpg)" >
<div class="content">
  <div class="title">
  	<div class="title_left"><img src="images/footer.png"/></div>
    <div class="title_right"><h2>欢迎使用学习资源共享系统</h2></div>
  </div>
  <div>
  <form action="LoginCheck.jsp" method="post">
  <table class="logTab">
  <tr>
    <td align="right">姓名:</td>
    <td><input type="text" name="username" placeholder="请输入姓名" class="input"></td>
  </tr>
  <tr>
    <td align="right">密码:</td>
    <td><input type="password" name="password" placeholder="请输入密码" class="input"></td>
  </tr>
  <tr >
    <td colspan="2" align="center"><input class="btn" type="submit" value="登录" /></td>
  </tr>
  </table>
  </form>
  </div>
  <span class="noReg"><a onClick="window.location.href='register.jsp'">还未注册</a></span>
</div>    
</body>
</html>