<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<link href="css/else.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="top">
    <div class="top_content">
       <ul>
          <li><a href="register.jsp">注册</a></li>
          <li><a href="login.jsp">登录</a></li>
       </ul>
    </div>
</div><!--top结束-->

<div class="wrap"  style="background:url(images/sharebg.jpg)">
   <div class="logo">
     <img src="images/logo.png" />
   </div><!--logo结束-->
   <div class="nav">  
      <div class="nav_mid">
         <div class="nav_mid_left">
            <ul>
               <li><a href="index.html">首页</a></li>
               <li><a href="ShowResList">资源中心</a></li>
               <li><a href="ShowMsgList" style="color:#FF9">交流论坛</a></li>
               <li><a href="upload.jsp">我要分享</a></li>
               <li><a href="userInfo.jsp">个人信息</a></li>
            </ul>
         </div>
         
         <div class="nav_mid_right">
            <form action="" method="post">
               <input type="text" class="searText"/>
            </form>
         </div>
      </div><!--nav_mid结束-->
   </div><!--nav结束-->  
    
   <div class="main">      
      <div class="secondNav">
         <ul>
           <li><a style="background-color:#FFC;color:#330000;">全部帖子</a></li>
           <li><a href="postMsg.jsp">我要发帖</a></li>
         </ul>
      </div>
      <div class="msgAll" style="height:400px;">
        <!--循环操作部分-->
        <c:forEach var="msg" items="${msgAll}">
        <div class="msgParent">
        <a class="msg">
             <img src="images/testa.jpg"/>
             <div class="msg_content"><h2>${msg.msgTitle}</h2><br/>
             <span>${msg.msgPoster}&nbsp;&nbsp;&nbsp;${msg.msgDate} </span>
             </div>
             <div class="msgFunc">                          
               <a><img src="images/view.png">查看</a>&nbsp;&nbsp;&nbsp;
               <a><img src="images/com.png">评论</a>
             </div>
        </a>
        </div>
        <div class="hr"></div>
        </c:forEach>
        <!--循环操作结束-->
     </div>
     
   </div><!--main结束-->
</div><!--wrap结束-->
<div class="clear"></div>
<div class="footer">
  <div class="footer_content">
        <img src="images/footer.png" />
        <br/>
        <span>联系方式：邮箱crystalhzr@163.com</span>
  </div>
</div>
</body>
</html>