package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UpdateService;
import service.UserService;
import vo.RegVo;
import vo.ResourceVo;

import com.jspsmart.upload.SmartUpload;

public class UDServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UDServlet() {
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
		 response.setCharacterEncoding("text/html;GBK"); 
         request.setCharacterEncoding("UTF-8");
         response.setContentType("text/html;charset=GBK");
         PrintWriter out = response.getWriter();
	    
 		String result="�ϴ��ɹ���";
		String sourcepath= this.getServletContext().getRealPath("/WEB-INF/upload");
		File file=new File(sourcepath);

		if(!file.exists()){
			file.mkdir();
			System.out.println("do noe exist");
			
			
		}
		
		SmartUpload su= new SmartUpload();
		//��ʼ�� ����
		su.initialize(getServletConfig(), request, response);
		
	
		
		try {
			
			
			su.upload();
			int a=su.save(sourcepath);
			
			System.out.println("�ϴ���"+a+"���ļ�");
			
			
		
 
	     su.service(request,response);
	     

	     String sourcename=new String(su.getRequest().getParameter("sourcename").trim().getBytes(),"utf-8");
	    
		 String sourcecontent=new String(su.getRequest().getParameter("sourcecontent").trim().getBytes(),"utf-8");
		 String sourcetype=su.getRequest().getParameter("sourcetype");
		 String path=su.getFiles().getFile(0).getFileName();
		//�ļ������붼��Ӣ�� smartuploadֻ֧��Ӣ��
		 System.out.println(path);
		 String sourcepic=su.getFiles().getFile(1).getFileName();
		 HttpSession session=request.getSession();
		 RegVo User=(RegVo)session.getAttribute("User");
		 String name= User.getName();
		 System.out.println(name);
		 System.out.println(sourcename);
 		 ResourceVo reso= new ResourceVo(sourcename,sourcecontent,path,sourcetype,name,sourcepic);
		 UpdateService rs=new UpdateService();
		int flag=rs.UpdateS(reso);
		if(flag==0){
			request.getRequestDispatcher("/wrong.html").forward(request, response);
			}
		else{
			out.print("<script language='javascript'> alert('�ϴ��ɹ�����');window.location.href='update.jsp';</script>");
			
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    result="�ϴ�ʧ�ܣ�";
		    System.out.println("ʧ��");
		}
	   
		
	   
		
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
