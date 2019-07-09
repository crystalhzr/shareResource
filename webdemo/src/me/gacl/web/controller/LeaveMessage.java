package me.gacl.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jaovo.msg.dao.MessageDaoImpl;
import com.jaovo.msg.model.Message;

/**留言操作*/
@WebServlet("/LeaveMessage")
public class LeaveMessage extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public LeaveMessage() {
     super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException {
     // 设置请求编码        
     request.setCharacterEncoding("utf-8");         
     // 设置响应编码        
     response.setContentType("utf-8");      
     // 获取message内容         
     String msgPoster=request.getParameter("msgPoster");              
     String msgTitle=request.getParameter("msgTitle");    
     String msgContent=request.getParameter("msgContent");    
     String msgDate=request.getParameter("msgDate");    
     // 从session中取出当前用户对象         
     //Login leaveMessageBoard=(Login) request.getSession().getAttribute("login");        
     // 建立留言表对应JavaBean对象，把数据封装进去        
     Message msg=new Message();
     msg.setmsgPoster(msgPoster);
     msg.setmsgTitle(msgTitle);
     msg.setmsgContent(msgContent);
     msg.setmsgDate(msgDate);
          
     // 参数为获取的当前时间            
     //mb.setTime(new Date(System.currentTimeMillis()));     
     MessageDaoImpl msgDaoImpl=new MessageDaoImpl();
     msgDaoImpl.add(msg);
		/*
		 * // 调DB类中的方法判断是否插入成功 if(new LoginDao().addInfo(mb)){
		 * response.sendRedirect("success.jsp") ; }
		 */
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException {
     doGet(request, response);
  }
}
