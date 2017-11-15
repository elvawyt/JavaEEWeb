package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ResourceService;
import vo.ResourceVo;

public class ShowResourceServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ShowResourceServlet() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	
		ResourceService reso= new ResourceService();
		ArrayList<ResourceVo> list=reso.ShowReso();
		HttpSession session=request.getSession();
		session.setAttribute("resource", list);
		
		
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
