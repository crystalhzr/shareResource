<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>下载文件显示页面</title>
    <link href="css/main.css" rel="stylesheet" type="text/css" />
    <link href="css/else.css" rel="stylesheet" type="text/css" />
<script>    
    function pass(obj){
    	var resname=obj.firstChild.id;
        window.location="resDetail.jsp?textValue="+resname;}
</script>
    
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

<div class="wrap">
   <div class="logo">
          <img src="images/logo.png" />
   </div><!--logo结束-->
   <div class="nav">  
      <div class="nav_mid">
         <div class="nav_mid_left">
            <ul>
               <li><a href="index.html">首页</a></li>
               <li><a href="ShowResList" style="color:#FF9">资源中心</a></li>
               <li><a href="ShowMsgList">交流论坛</a></li>
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
    
   <div class="main" style="height:400px;background:url(images/sharebg.jpg)">      
      <div class="secondNav">
         <ul>
           <li><a style="background-color:#FFC;color:#330000;">全部资源</a></li>
           <li><a>考研材料</a></li>
           <li><a>期末复习</a></li>
           <li><a>往年试卷</a></li>
           <li><a>学习笔记</a></li>
         </ul>
      </div>
      <div class="listAll"><!--listAll开始-->
      <c:forEach var="res" items="${resAll}">
        <a class="list" onclick="pass(this)" id="cry"><img src="images/default.jpg" id="${res.resoceName}">
        <h4>${res.resoceName}</h4>
        <span>${res.resoceAuthor}</span>
        </a>
<%--    学习资源信息展示
           <img src="default"/>
           <h4>文章标题</h4>
           <span>文章分享者</span>
        <span>文件名</span>${res.resoceName}<br/>
        <span>文件位置</span>${res.resoceLoc}<br/>
        <span>分享者</span>${res.resoceAuthor}<br/>
        <span>文件类型</span>${res.type}<br/>
        <span>文件名</span>${res.resoceName}<br/>
        <span>文件名</span><br/>
        ${res.resoceLoc}
        <br/> --%>
       </c:forEach>
       </div><!--listAll结束-->
     
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