package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.SearchService;
import vo.ResourceVo;

public class MSearchServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MSearchServlet() {
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
		String key=request.getParameter("key");
		SearchService ss=new SearchService();
		ArrayList<ResourceVo> list=ss.selectResourceType(key);
		HttpSession session=request.getSession();
		session.setAttribute("ResourceList", list);
		request.getRequestDispatcher("/searchr.jsp").forward(request,response);
		
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
