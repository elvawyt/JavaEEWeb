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
import service.ResourceService;
import vo.AskVo;
import vo.ResourceVo;

public class FirstPageServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FirstPageServlet() {
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


		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		QuestionTest qt=new QuestionTest();
		ArrayList<AskVo> question=qt.selectQuestion();
		HttpSession session=request.getSession();
		session.setAttribute("question1", question);
		
		
		ResourceService reso= new ResourceService();
		ArrayList<ResourceVo> list=reso.ShowReso();
		
		session.setAttribute("resource1", list);
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
