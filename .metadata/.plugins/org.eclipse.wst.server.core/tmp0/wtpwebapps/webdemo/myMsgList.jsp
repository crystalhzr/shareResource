<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<link href="css/else.css" rel="stylesheet" type="text/css" />
<link href="css/myMsg.css" rel="stylesheet" type="text/css" />
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
               <li><a href="ShowResList">资源中心</a></li>
               <li><a href="ShowMsgList">交流论坛</a></li>
               <li><a href="upload.jsp">我要分享</a></li>
               <li><a href="userInfo.jsp" style="color:#FF9">个人信息</a></li>
            </ul>
         </div>
         
         <div class="nav_mid_right">
            <form action="" method="post">
               <input type="text" class="searText"/>
            </form>
         </div>
      </div><!--nav_mid结束-->
   </div><!--nav结束-->  
    
   <div class="main" style="background:url(images/sharebg.jpg);height:400px;">      
      <div class="secondNav">
         <ul>
           <li><a href="userInfo.jsp" style="text-decoration: none;">我的信息</a></li>
           <li><a href="changePswd.jsp" style="text-decoration: none;">修改密码</a></li>
           <li><a href="myMsgList.jsp" style="text-decoration: none;background-color:#FFC;color:#330000;">我的帖子</a></li>
           <li><a>草稿箱</a></li>
         </ul>
      </div>
      <div class="myMsgs">
        <a class="myMsg">
           <img src="default"/>
           <h4>文章标题</h4>
           <span>文章分享者</span>
        </a>
        <a class="myMsg">
           <img src="default"/>
           <h4>文章标题</h4>
           <span>文章分享者</span>
        </a>

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