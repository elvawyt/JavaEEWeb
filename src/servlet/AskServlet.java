package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.AskService;
import service.RegService;
import vo.AskVo;
import vo.RegVo;

public class AskServlet extends HttpServlet {

	
	public AskServlet() {
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
		 response.setCharacterEncoding("text/html;UTF-8"); 
         request.setCharacterEncoding("UTF-8");
         response.setContentType("text/html;charset=utf-8");
         PrintWriter out = response.getWriter();
      
 		
 		String qtitle=request.getParameter("qtitle");		
 		String qcontent=request.getParameter("qcontent");
 		String qtype=request.getParameter("qtype");
 		HttpSession session=request.getSession();
		RegVo User=(RegVo)session.getAttribute("User");
		String name= User.getName();
 		AskVo ask= new AskVo(qtitle, qcontent, qtype,name);
 		AskService rs=new AskService();
 		int flag=rs.AskQ(ask);
 		if(flag==0){
 			request.getRequestDispatcher("/wrong.jsp").forward(request, response);
 			}
 		else{
 			out.print("<script language='javascript'> alert('提问成功啦');window.location.href='ask.jsp';</script>");
			
 			}
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
