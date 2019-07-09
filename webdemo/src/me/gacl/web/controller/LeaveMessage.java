package me.gacl.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jaovo.msg.dao.MessageDaoImpl;
import com.jaovo.msg.model.Message;

/**���Բ���*/
@WebServlet("/LeaveMessage")
public class LeaveMessage extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public LeaveMessage() {
     super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException {
     // �����������        
     request.setCharacterEncoding("utf-8");         
     // ������Ӧ����        
     response.setContentType("utf-8");      
     // ��ȡmessage����         
     String msgPoster=request.getParameter("msgPoster");              
     String msgTitle=request.getParameter("msgTitle");    
     String msgContent=request.getParameter("msgContent");    
     String msgDate=request.getParameter("msgDate");    
     // ��session��ȡ����ǰ�û�����         
     //Login leaveMessageBoard=(Login) request.getSession().getAttribute("login");        
     // �������Ա��ӦJavaBean���󣬰����ݷ�װ��ȥ        
     Message msg=new Message();
     msg.setmsgPoster(msgPoster);
     msg.setmsgTitle(msgTitle);
     msg.setmsgContent(msgContent);
     msg.setmsgDate(msgDate);
          
     // ����Ϊ��ȡ�ĵ�ǰʱ��            
     //mb.setTime(new Date(System.currentTimeMillis()));     
     MessageDaoImpl msgDaoImpl=new MessageDaoImpl();
     msgDaoImpl.add(msg);
		/*
		 * // ��DB���еķ����ж��Ƿ����ɹ� if(new LoginDao().addInfo(mb)){
		 * response.sendRedirect("success.jsp") ; }
		 */
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException {
     doGet(request, response);
  }
}
