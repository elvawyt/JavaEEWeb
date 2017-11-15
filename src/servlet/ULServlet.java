package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import service.UpdateService;
import vo.RegVo;
import vo.ResourceVo;

public class ULServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ULServlet() {
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
		 response.setCharacterEncoding("text/html;UTF-8"); 
         request.setCharacterEncoding("UTF-8");
         
         PrintWriter out = response.getWriter();
         String sourcename=request.getParameter("sourcename");
         System.out.println(sourcename);
 	    
		 String sourcecontent=request.getParameter("sourcecontent");
		 String sourcetype=request.getParameter("sourcetype");
		 String path=request.getParameter("file1");
		 System.out.println(path);
		
		 
		 String sourcepic=request.getParameter("file2");
		 HttpSession session=request.getSession();
		 RegVo User=(RegVo)session.getAttribute("User");
		 String name= User.getName();
		 System.out.println("���");
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
			
		 String savePath = this.getServletContext().getRealPath("WEB-INF/upupup");
		 File file = new File(savePath);
		 if(!file.exists()&& !file.isDirectory()){
			 System.out.println(savePath+"Ŀ¼�����ڣ����´���");
			 file.mkdir();
		 }
		 String message="";
		 try{
		 DiskFileItemFactory factory= new DiskFileItemFactory();
		 ServletFileUpload upload = new ServletFileUpload(factory);
		 upload.setHeaderEncoding("UTF-8");  
		 if(!ServletFileUpload.isMultipartContent(request)){ 
			 //���մ�ͳ��ʽ��ȡ���� 
			 return;
		 }
		 List<FileItem> list = upload.parseRequest(request); 
		 for(FileItem item : list){ 
			 //���fileitem�з�װ������ͨ����������� 
			 if(item.isFormField()){ String namee = item.getFieldName(); //�����ͨ����������ݵ������������� 
			 String value = item.getString("UTF-8"); //value = new String(value.getBytes("iso8859-1"),"UTF-8"); 
			 System.out.println(namee + "=" + value); }
			 else{
				 //���fileitem�з�װ�����ϴ��ļ�
				 //�õ��ϴ����ļ����ƣ� 
				 String filename = item.getName(); 
				 System.out.println(filename); 
				 if(filename==null || filename.trim().equals("")){ 
					 continue; } 
				 filename = filename.substring(filename.lastIndexOf("\\")+1); //��ȡitem�е��ϴ��ļ��������� 
				 InputStream in = item.getInputStream(); //����һ���ļ������ 
				 FileOutputStream outt = new FileOutputStream(savePath + "\\" + filename); //����һ�������� 
				 byte buffer[] = new byte[1024]; //�ж��������е������Ƿ��Ѿ�����ı�ʶ 
				 int len = 0; //ѭ�������������뵽���������У�(len=in.read(buffer))>0�ͱ�ʾin���滹������
				 while((len=in.read(buffer))>0){ //ʹ��FileOutputStream�������������������д�뵽ָ����Ŀ¼(savePath + "\\" + filename)����
					 outt.write(buffer, 0, len); } //�ر������� 
				 in.close(); //�ر������
				 out.close(); //ɾ�������ļ��ϴ�ʱ���ɵ���ʱ�ļ� 
				 item.delete(); 
				 message = "�ļ��ϴ��ɹ���"; } }
		 

	    
		}
		 
		 catch (Exception e) { 
			 message= "�ļ��ϴ�ʧ�ܣ�"; e.printStackTrace();   
			 } 
		 request.setAttribute("message",message); 
		 request.getRequestDispatcher("/message.jsp").forward(request, response); }
		 } 
				 

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		doGet(request, response);
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
