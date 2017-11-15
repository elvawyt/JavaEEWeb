package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.net.URLEncoder;

public class DLServlet extends HttpServlet {

	
	public DLServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            String sourcename = request.getParameter("pathh");
            System.out.println(sourcename);
            String path=this.getServletContext().getRealPath("/WEB-INF/upload");
            
            String realname= sourcename.substring(sourcename.indexOf("_")+1);
            response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8")); //��ȡҪ���ص��ļ������浽�ļ������� 
            FileInputStream in = new FileInputStream(path + "\\" + sourcename); //��������� 
            OutputStream out = response.getOutputStream(); //���������� 
            byte buffer[] = new byte[1024]; int len = 0; //ѭ�����������е����ݶ�ȡ������������
            while((len=in.read(buffer))>0){ 
            //��������������ݵ��������ʵ���ļ����� 
            	out.write(buffer, 0, len); } //�ر��ļ������� 
            in.close(); //�ر������ 
            out.close(); 
            
            
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
