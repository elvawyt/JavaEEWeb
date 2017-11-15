package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import javax.servlet.http.HttpSession;

import service.RegService;
import vo.RegVo;


public class RegServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegServlet() {
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
		out.println("test1");
		String username=request.getParameter("username");		
		String password=request.getParameter("password");
		String role="user";
		RegVo user=new RegVo(username,password,role);
		RegService rs=new RegService();
		String checkCode=request.getParameter("checkcode");		
		HttpSession session=request.getSession();
		String code=(String)session.getAttribute("rand");
	
	if(checkCode.equals(code))
		{    
		int flag=rs.RegistUser(user);
		if(flag==0){
			request.getRequestDispatcher("/wrong.jsp").forward(request, response);
			}
		else{
			request.setAttribute("username", username);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			}}
		
		
	else{
			out.print("<script language='javascript'> alert('ÑéÖ¤Âë´íÎó');window.location.href='pass.jsp';</script>");
			
		}
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
