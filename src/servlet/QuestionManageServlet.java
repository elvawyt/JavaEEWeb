package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.QuestionTest;
import vo.AskVo;

public class QuestionManageServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QuestionManageServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String type=request.getParameter("type");	
		
		System.out.println("hahahahaah");
		if(type.equals("deleteq")){
		QuestionTest qu = new QuestionTest();
		
		String qtitle=request.getParameter("qtitle");
		qtitle= new String(qtitle.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(qtitle);
		int i=qu.DeleteQuestion(qtitle);
		 if(i==0){
				request.getRequestDispatcher("/error.html").forward(request, response);
			}
			else{
				out.print("<script language='javascript'> alert('³É¹¦À²£¡');window.location.href='querymanage.jsp';</script>");
		 
			}
	}
		
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
