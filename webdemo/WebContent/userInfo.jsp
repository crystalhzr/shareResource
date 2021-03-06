<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>个人信息</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<link href="css/else.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function altRows(id){
	if(document.getElementsByTagName){  
		
		var table = document.getElementById(id);  
		var rows = table.getElementsByTagName("tr"); 
		 
		for(i = 0; i < rows.length; i++){          
			if(i % 2 == 0){
				rows[i].className = "evenrowcolor";
			}else{
				rows[i].className = "oddrowcolor";
			}      
		}
	}
}
 
window.onload=function(){
	altRows('alternatecolor');
}
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
           <li><a style="background-color:#FFC;color:#330000;">我的信息</a></li>
           <li><a href="changePswd.jsp" style="text-decoration: none;">修改密码</a></li>
           <li><a href="myMsgList.jsp" style="text-decoration: none;">我的帖子</a></li>
           <li><a>草稿箱</a></li>
         </ul>
      </div>
      <div class="info">
        <table class="pswdTab" id="alternatecolor">
            <thead>
                <tr>
                    <th>用户名：</th>
                    <th>何湛蓉</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>邮箱：</td>
                    <td>crystalhzr@163.com</td>
                </tr>
                <tr>
                    <td>学校：</td>
                    <td>武汉理工大学</td>
                </tr>
                <tr>
                    <td>学院：</td>
                    <td>管理学院</td>
                </tr>
                <tr>
                    <td>专业：</td>
                    <td>信息管理与信息系统</td>
                </tr>
            </tbody>
        </table>
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