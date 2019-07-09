<%@page import="com.jaovo.msg.model.Resource"%>
<%@page import="com.jaovo.msg.dao.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
    <link href="css/main.css" rel="stylesheet" type="text/css" />
    <link href="css/else.css" rel="stylesheet" type="text/css" />
</head>
<script>    
    function resLoad(){
    	var target=document.getElementById("title");
    	var content=target.innerHTML;
    	var index=content.indexOf(":");
    	var name=content.substr(index+1);
        window.location="DownloadHandleServlet?textValue="+name;
        }
</script>
<body>
<%
    //接收客户端传递过来的参数,获取下载列表点击项信息
    String resname =request.getParameter("textValue");
    System.out.print(resname);
    ResourceDAOImpl resDao = new ResourceDAOImpl();
	Resource resource=resDao.loadByResname(resname);
	request.setAttribute("res", resource);
%>
<div class="top">
    <div class="top_content">
       <ul>
          <li><a href="#" onclick="">注册</a></li>
          <li><a href="#" onclick="">登录</a></li>
       </ul>
    </div>
</div><!--top结束-->

<div class="wrap"  style="background:url(images/sharebg.jpg); padding-bottom:20px;">
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
    
   <div class="main">      
      <div class="detail" >
        <div class="detail_left">
           <div class="img_boder"><img src="images/default.jpg"></div>
        </div>
        <!--开始输出传递的信息-->
        <div class="detail_right">
           <div class="de_title">
             <img src="images/图片3.png">
             <span id="title">资料名称:${res.resoceName}</span>
           </div>
           <div class="de_secTitle">
             <span>资料分享者:${res.resoceAuthor}</span>
             <span>上传日期:${res.date}</span>
           </div>
           <div class="de_func">
             <a><img src="images/view.png">查看</a>
             <a onclick="resLoad()"><img src="images/down.png">下载</a>
             <a><img src="images/com.png">评论</a>
           </div>
           <div class="clear"></div>
           <div class="de_content">
             <div class="type">资料类别：${res.type}</div>
             <div class="type">资料简述：${res.describe}</div>
           </div>
        </div>
        <!--结束输出传递的信息-->
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