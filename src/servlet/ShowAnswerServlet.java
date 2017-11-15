package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.AnswerService;
import service.QuestionTest;
import vo.AnswerVo;
import vo.AskVo;

public class ShowAnswerServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ShowAnswerServlet() {
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

		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String qtitlee=request.getParameter("qtitle");
		qtitlee= new String(qtitlee.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(qtitlee);
		AnswerService rs=new AnswerService();
		String name=request.getParameter("username");
		name=new String(name.getBytes("ISO-8859-1"),"UTF-8");
		ArrayList<AnswerVo> more=rs.ShowAnswer(qtitlee);
		HttpSession session=request.getSession();
		session.setAttribute("answer", more);
		
		
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
