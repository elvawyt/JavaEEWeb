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
		 System.out.println("这里！");
		 System.out.println(name);
		 System.out.println(sourcename);
 		 ResourceVo reso= new ResourceVo(sourcename,sourcecontent,path,sourcetype,name,sourcepic);
		 UpdateService rs=new UpdateService();
		int flag=rs.UpdateS(reso);
		if(flag==0){
			request.getRequestDispatcher("/wrong.html").forward(request, response);
			}
		else{
			out.print("<script language='javascript'> alert('上传成功啦！');window.location.href='update.jsp';</script>");
			
		 String savePath = this.getServletContext().getRealPath("WEB-INF/upupup");
		 File file = new File(savePath);
		 if(!file.exists()&& !file.isDirectory()){
			 System.out.println(savePath+"目录不存在，重新创建");
			 file.mkdir();
		 }
		 String message="";
		 try{
		 DiskFileItemFactory factory= new DiskFileItemFactory();
		 ServletFileUpload upload = new ServletFileUpload(factory);
		 upload.setHeaderEncoding("UTF-8");  
		 if(!ServletFileUpload.isMultipartContent(request)){ 
			 //按照传统方式获取数据 
			 return;
		 }
		 List<FileItem> list = upload.parseRequest(request); 
		 for(FileItem item : list){ 
			 //如果fileitem中封装的是普通输入项的数据 
			 if(item.isFormField()){ String namee = item.getFieldName(); //解决普通输入项的数据的中文乱码问题 
			 String value = item.getString("UTF-8"); //value = new String(value.getBytes("iso8859-1"),"UTF-8"); 
			 System.out.println(namee + "=" + value); }
			 else{
				 //如果fileitem中封装的是上传文件
				 //得到上传的文件名称， 
				 String filename = item.getName(); 
				 System.out.println(filename); 
				 if(filename==null || filename.trim().equals("")){ 
					 continue; } 
				 filename = filename.substring(filename.lastIndexOf("\\")+1); //获取item中的上传文件的输入流 
				 InputStream in = item.getInputStream(); //创建一个文件输出流 
				 FileOutputStream outt = new FileOutputStream(savePath + "\\" + filename); //创建一个缓冲区 
				 byte buffer[] = new byte[1024]; //判断输入流中的数据是否已经读完的标识 
				 int len = 0; //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
				 while((len=in.read(buffer))>0){ //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
					 outt.write(buffer, 0, len); } //关闭输入流 
				 in.close(); //关闭输出流
				 out.close(); //删除处理文件上传时生成的临时文件 
				 item.delete(); 
				 message = "文件上传成功！"; } }
		 

	    
		}
		 
		 catch (Exception e) { 
			 message= "文件上传失败！"; e.printStackTrace();   
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
