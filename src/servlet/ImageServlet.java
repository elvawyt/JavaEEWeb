package servlet;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ImageServlet extends HttpServlet {

	  private static final long serialVersionUID = 1L;  
	  
	    public ImageServlet() {  
	        super();  
	    }  
	  
	    public void destroy() {  
	        super.destroy();   
	    }  
	  
	    public void init() throws ServletException {  
	        super.init();  
	    }  
	    /*�÷�����Ҫ�����ǻ��������ɵ���ɫ*/   
	    public Color getRandColor(int s,int e){  
	        Random random=new Random ();  
	        if(s>255) s=255;  
	        if(e>255) e=255;  
	        int r,g,b;  
	        r=s+random.nextInt(e-s);    //�������RGB��ɫ�е�rֵ  
	        g=s+random.nextInt(e-s);    //�������RGB��ɫ�е�gֵ  
	        b=s+random.nextInt(e-s);    //�������RGB��ɫ�е�bֵ  
	        return new Color(r,g,b);  
	    }  
	  
	    @Override  
	    public void service(HttpServletRequest request, HttpServletResponse response)  
	            throws ServletException, IOException {  
	        //���ò�����ͼƬ  
	        response.setHeader("Pragma", "No-cache");  
	        response.setHeader("Cache-Control", "No-cache");  
	        response.setDateHeader("Expires", 0);  
	        //ָ�����ɵ���ӦͼƬ,һ������ȱ����仰,�������.  
	        response.setContentType("image/jpeg");  
	        int width=100,height=37;     //ָ��������֤��Ŀ�Ⱥ͸߶�  
	        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB); //����BufferedImage����,�������൱��һͼƬ  
	        Graphics g=image.getGraphics();     //����Graphics����,�������൱�ڻ���  
	        Graphics2D g2d=(Graphics2D)g;       //����Grapchics2D����  
	        Random random=new Random();  
	        Font mfont=new Font("����",Font.BOLD,28); //����������ʽ  
	        g.setColor(getRandColor(200,250));  
	        g.fillRect(0, 0, width, height);    //���Ʊ���  
	        g.setFont(mfont);                   //��������  
	        g.setColor(getRandColor(180,200));  
	          
	        //����100����ɫ��λ��ȫ��Ϊ�������������,������Ϊ2f  
	        for(int i=0;i<100;i++){  
	            int x=random.nextInt(width-1);  
	            int y=random.nextInt(height-1);  
	            int x1=random.nextInt(6)+1;  
	            int y1=random.nextInt(12)+1;  
	            BasicStroke bs=new BasicStroke(2f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL); //����������ʽ  
	            Line2D line=new Line2D.Double(x,y,x+x1,y+y1);  
	            g2d.setStroke(bs);  
	            g2d.draw(line);     //����ֱ��  
	        }  
	        //�����Ӣ�ģ����������ɵ���֤���֣��������Ϸ�ʽ�������������ȷ����  
	        String sRand="";  
	        String ctmp="";  
	        int itmp=0;  
	        //�ƶ��������֤��Ϊ��λ  
	        for(int i=0;i<4;i++){  
	            switch(random.nextInt(3)){  
	                case 1:     //����A-Z����ĸ  
	                     itmp=random.nextInt(26)+65;  
	                     ctmp=String.valueOf((char)itmp);  
	                     break;  
	               
	                default:  
	                     itmp=random.nextInt(10)+48;  
	                     ctmp=String.valueOf((char)itmp);  
	                     break;  
	            }  
	            sRand+=ctmp;  
	            Color color=new Color(20+random.nextInt(110),20+random.nextInt(110),random.nextInt(110));  
	            g.setColor(color);  
	            //�����ɵ����������������Ų���ת�ƶ��Ƕ� PS.���鲻Ҫ�����ֽ�����������ת,��Ϊ����ͼƬ���ܲ�������ʾ  
	            /*��������ת�ƶ��Ƕ�*/  
	            Graphics2D g2d_word=(Graphics2D)g;  
	            AffineTransform trans=new AffineTransform();  
	            trans.rotate((45)*3.14/180,15*i+8,7);  
	            /*��������*/  
	            float scaleSize=random.nextFloat()+0.8f;  
	            if(scaleSize>1f) scaleSize=1f;  
	            trans.scale(scaleSize, scaleSize);  
	            g2d_word.setTransform(trans);  
	            g.drawString(ctmp, 15*i+18, 14);  
	        }  
	        HttpSession session=request.getSession();
	        session.setAttribute("rand", sRand);
	        g.dispose();    //�ͷ�g��ռ�õ�ϵͳ��Դ  
	        ImageIO.write(image,"JPEG",response.getOutputStream()); //���ͼƬ 
	    }  
	} 

