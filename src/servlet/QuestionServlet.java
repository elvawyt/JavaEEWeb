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

public class QuestionServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QuestionServlet() {
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
		
		QuestionTest qt=new QuestionTest();
		ArrayList<AskVo> question=qt.selectQuestion();
		HttpSession session=request.getSession();
		session.setAttribute("question", question);
		
		
		
		
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
