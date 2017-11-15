package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;

import vo.RegVo;


public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username=request.getParameter("username");		
		String password=request.getParameter("password");
		
		HttpSession session=request.getSession();
		
		LoginService rs= new LoginService();
		RegVo user =new RegVo(username,password);
		int i=rs.getBeliever(user);
		if(i==0){
			System.out.println("´íÎó");
			response.sendRedirect("login.jsp?error=dismatch");
		}
		else{
			RegVo userDetail=rs.getDetail(username);
			session.setAttribute("User", userDetail);
			String r=userDetail.getRole();
			if(r.equals("user")){
				request.getRequestDispatcher("/user.jsp").forward(request, response);
			}
			else if(r.equals("admin")){
				request.getRequestDispatcher("/usermanage.jsp").forward(request, response);
			}
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
