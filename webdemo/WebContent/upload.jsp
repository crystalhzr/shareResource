<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>文件上传</title>
    <link href="css/main.css" rel="stylesheet" type="text/css" />
    <link href="css/else.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
  <!--后台返回信息-->
  <%
    String msg=(String)request.getAttribute("message");
	if(!"".equals(msg) && msg!=null){
  %>
 	<script type="text/javascript">
		alert("<%=msg%>");
    </script>
   <% }%>
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
               <li><a href="upload.jsp" style="color:#FF9">我要分享</a></li>
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
    
   <div class="main" style="background:url(images/sharebg.jpg);height:500px;">      
    <div>
    <form action="UploadHandleServlet" enctype="multipart/form-data" method="post">        
        <table class="fileTab">
          <tr>
            <td align="right">请选择你要分享的文件类别</td>
            <td>            
            <select class="input" name="resType" value="${classmates.type}">
              <option value="kaoyan"${classmates.type eq "kaoyan"?"selected='selected'":""}>考研材料</option>
              <option value="qimo"${classmates.type eq "qimo"?"selected='selected'":""}>期末复习</option>
              <option value="shijuan"${classmates.type eq "shijuan"?"selected='selected'":""}>往年试卷</option>
              <option value="biji"${classmates.type eq "biji"?"selected='selected'":""}>学习笔记</option>
           </select>
            </td>
          </tr>
          <tr>
            <td align="right">资源分享者：</td>
            <td><input type="text" name="resAuthor" class="input" placeholder="请输入资源分享者"></td>
          </tr>
          <tr>
            <td align="right">文件名：</td>
            <td><input type="text" name="resName" class="input" placeholder="请输入文件名"></td>
          </tr>
          <tr>
            <td align="right">资源标题：</td>
            <td><input type="text" name="resTitle" class="input" placeholder="请输入资源标题"></td>
          </tr>
          <tr>
            <td align="right">资源描述：</td>
            <td><input type="text" name="describe" class="input" placeholder="请输入资源描述"></td>
          </tr>
          <tr>
            <td align="right">上传日期：</td>
            <td><input type="date" name="resDate" class="input" placeholder="请输入上传日期"></td>
          </tr>
          <tr>
            <td align="right">上传文件：</td>
            <td><input type="file" name="file1"></td>
          </tr>
          <tr>
            <td colspan="2"><input type="submit" value="分享" class="subBtn"></td>
          </tr>
       </table>
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