<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>发帖</title>
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

<div class="wrap">
   <div class="logo">
             <img src="images/logo.png" />
   </div><!--logo结束-->
   <div class="nav">  
      <div class="nav_mid">
         <div class="nav_mid_left">
            <ul>
               <li><a href="index.html" style="color:#FF9">首页</a></li>
               <li><a href="ShowResList">资源中心</a></li>
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
    
   <div class="main">      
      <div class="secondNav">
         <ul>
           <li><a>全部帖子</a></li>
           <li><a style="color:#900; background-color:#FFC">我要发帖</a></li>
         </ul>
      </div>
      <div class="postContent">
      <form action="addMsg.jsp" method="get">
          <div class="postFunc">
            <input type="submit" value="发送" class="send">
            <input type="button" value="存草稿" class="elseBtn">
            <input type="button" value="取消" class="elseBtn">
          </div>
          <div class="postDetail">
              <label>发帖人：<input type="text" class="postInput" name="msgPoster" placeholder="请输入发贴人用户名" ></label><br/>
              <label>&nbsp;标题：<input type="text" class="postInput" name="msgTitle" placeholder="请输入帖子主题" ></label><br/>
              <label>&nbsp;时间：<input type="text" class="postInput" name="msgDate" placeholder="请输入上传时间" ></label><br/>
              <label>&nbsp;内容：</label><br/>
              <textarea class="postArea" name="msgContent" placeholder="请输入您要发布的内容" ></textarea>
          </div>
      </form>    
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