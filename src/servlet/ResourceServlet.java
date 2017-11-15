package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ResourceService;

public class ResourceServlet extends HttpServlet {

	
	public ResourceServlet() {
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
		String type=request.getParameter("type");
		if(type.equals("changepermission")){
			String sourcename= request.getParameter("sourcename");
			ResourceService change= new ResourceService();
			int i=change.ChangeP(sourcename);
		 if(i==0){
					request.getRequestDispatcher("/wrong.html").forward(request, response);
					}
				else{
					
					out.print("<script language='javascript'> alert('成功啦！');window.location.href='resourcemanage.jsp';</script>");
				}
			
		}
		
		if(type.equals("agreeupload")){
			String sourcename= request.getParameter("sourcename");
			ResourceService change= new ResourceService();
			int i=change.AgreeU(sourcename);
		 if(i==0){
					request.getRequestDispatcher("/wrong.html").forward(request, response);
					}
				else{
					
					out.print("<script language='javascript'> alert('成功啦！');window.location.href='resourcemanage.jsp';</script>");
				}
			
		}
		

		if(type.equals("filter")){
			
			request.getRequestDispatcher("/resourcefilter.jsp").forward(request, response);
			
	}
	}
	
	 

	
	public void init() throws ServletException {
		// Put your code here
	}

}
