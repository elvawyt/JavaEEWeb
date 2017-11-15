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
import vo.UserVo;

public class ResourceManage extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ResourceManage() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ResourceService reso= new ResourceService();
		ArrayList<ResourceVo> list=reso.ShowReso();
		HttpSession session=request.getSession();
		session.setAttribute("resource", list);
		
		
		
		
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
