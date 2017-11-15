package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.RegService;
import service.UserService;
import vo.UserVo;

public class UserServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserServlet() {
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
		 response.setCharacterEncoding("text/html;UTF-8"); 
         request.setCharacterEncoding("UTF-8");
         response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String phone=request.getParameter("phone");
		String pic=request.getParameter("pic");
		String username=request.getParameter("username");
		String lable[]=request.getParameterValues("hobby");
		String type=request.getParameter("type");
		if(type.equals("complete")){
			String Hobbies="";
			for(int i=0;i<lable.length;i++){
				if(lable[i]!=null){
					Hobbies+=lable[i]+",";
				}}
			System.out.println(Hobbies);
     	
     		
			UserVo user= new UserVo(name, username, sex, phone, pic, Hobbies);
			UserService rs=new UserService();
			int flag=rs.RegisterU(user);
			if(flag==0){
				request.getRequestDispatcher("/wrong.html").forward(request, response);
			}
			else{
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		
		}
		
		
		 if(type.equals("changerank")){
			 UserService us= new UserService();
			 int i=us.ChangeRank(username);
			 if(i==0){
					request.getRequestDispatcher("/wrong.html").forward(request, response);
					}
				else{
					ArrayList<UserVo> list=us.ShowUser();
					HttpSession session=request.getSession();
					session.setAttribute("user", list);
					out.print("<script language='javascript'> alert('成功啦！');window.location.href='usermanage.jsp';</script>");
				}
			 
			 
		 }
		
		 if(type.equals("deleteuser")){
			 UserService us = new UserService();
			 int i=us.deleteUser(username);
			 if(i==0){
					request.getRequestDispatcher("/wrong.html").forward(request, response);
				}
				else{
					out.print("<script language='javascript'> alert('成功啦！');window.location.href='usermanage.jsp';</script>");
			 
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
