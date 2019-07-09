<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>用户添加页面</title>
    <link href="css/log.css" rel="stylesheet">
</head>
<body style="background:url(images/logbg.jpg)" >
<div class="content">
  <div class="title">
  	<div class="title_left"><img src="images/footer.png"/></div>
    <div class="title_right"><h2>欢迎使用学习资源共享系统</h2></div>
  </div>
  <div>
  <form action="addUser.jsp" method="get">
  <table class="regTab">
  <tr>
    <td align="right">用户名:</td>
    <td><input name="username" type="text" placeholder="请输入用户名" class="input"></td>
  </tr>
  <tr>
    <td align="right">密码:</td>
    <td><input name="password" type="password"  placeholder="请输入密码" class="input"></td>
  </tr>
  <tr>
    <td align="right">确认密码:</td>
    <td><input name="confirmword" type="password"  placeholder="请确认密码" class="input"></td>
  </tr>
  <tr>
    <td align="right">邮箱:</td>
    <td><input name="email" type="email"  placeholder="请输入邮箱" class="input"></td>
  </tr>
  <tr>
    <td align="right">学校:</td>
    <td><input name="school" type="text"  placeholder="请输入学校" class="input"></td>
  </tr>
  <tr>
    <td align="right">学院:</td>
    <td>
      <select class="input" name="college">
        <option value="0">请选择学院</option>
        <option value="1">管理学院</option>
        <option value="2">材料学院</option>
        <option value="3">自动化学院</option>
        <option value="4">资环学院</option>
        <option value="4">化生学院</option>
        <option value="4">汽车学院</option>
      </select>
    </td>
  </tr>
  <tr>
    <td align="right">专业:</td>
    <td><input name="profession" type="text"  placeholder="请输入专业" class="input"></td>
  </tr>
  <tr>
    <td colspan="2" align="center"><input class="btn" type="submit" value="注册" /></td>
  </tr>
  </table>
  </form>
  </div>
  <span class="noReg"><a href="login.jsp">去登录</a></span>
</div>
</body>
</html>