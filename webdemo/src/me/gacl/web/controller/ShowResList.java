package me.gacl.web.controller;

import java.io.IOException;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jaovo.msg.dao.*;
import com.jaovo.msg.model.Resource;

public class ShowResList extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ResourceDAOImpl resDao = new ResourceDAOImpl();
		List<Resource> resAll = resDao.loadAll();
		request.setAttribute("resAll", resAll);
		request.getRequestDispatcher("/resList.jsp").forward(request, response);
	}
}