package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.QuestionTest;
import vo.AskVo;

public class DetailServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DetailServlet() {
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
		String type=request.getParameter("type");
		
		String qtitle=request.getParameter("qtitle");
		qtitle=new String(qtitle.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(qtitle);
		String name=request.getParameter("username");
		name=new String(name.getBytes("ISO-8859-1"),"UTF-8");
		QuestionTest qt=new QuestionTest();
		if(type.equals("detail")){
			AskVo detail=qt.selectDetail(qtitle);
			System.out.println(qtitle);
			HttpSession session=request.getSession();
			session.setAttribute("question", detail);
			request.setAttribute("name", name);
			request.getRequestDispatcher("/answer.jsp").forward(request,response);
			
		}
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
