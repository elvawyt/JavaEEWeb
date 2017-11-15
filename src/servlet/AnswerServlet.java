package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.AnswerService;
import vo.AnswerVo;
import vo.RegVo;

public class AnswerServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AnswerServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
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
		
		String acontent=request.getParameter("acontent");
		//acontent=new String(acontent.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("servlet");
		System.out.println(acontent);
		String name=request.getParameter("name");
		//name=new String(name.getBytes("ISO-8859-1"),"UTF-8");
		
		String qtitle=request.getParameter("qtitle");
		//qtitle= new String(qtitle.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(qtitle);
		String agree=null;
		
		AnswerVo ans= new AnswerVo(acontent,agree,qtitle,name);
		AnswerService re= new AnswerService();
		int i=re.InsertAnswer(ans);
		if(i==0){
 			request.getRequestDispatcher("/wrong.jsp").forward(request, response);
 			}
 		else{
 			out.print("<script language='javascript'> alert('»Ø´ð³É¹¦À²');window.location.href='query.jsp';</script>");
			
 			}
		
		
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
