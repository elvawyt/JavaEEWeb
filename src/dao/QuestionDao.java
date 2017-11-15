package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionFactory;
import vo.AskVo;


public class QuestionDao {
	public ArrayList<AskVo> selectAll()
	{
		ArrayList<AskVo> list=new ArrayList<AskVo>();
		try {
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from question;");
			ResultSet rs=ps.executeQuery();//Ö´ÐÐ
			while(rs.next()){
				AskVo question=new AskVo(rs.getString("qtitle"),rs.getString("qcontent"),rs.getString("qtype"),rs.getString("name"));
			list.add(question);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	 public AskVo selectDetail(String qtitle){
		 AskVo detail=new AskVo();
		 Connection conn=ConnectionFactory.getConnection();
		 try {
			String sql="select * from question where qtitle='"+qtitle+"'";
			PreparedStatement state=conn.prepareStatement(sql);
			ResultSet rs=state.executeQuery();
			if(rs.next()){
				detail.setQtitle(rs.getString("qtitle"));
				detail.setQcontent(rs.getString("qcontent"));
				detail.setQtype(rs.getString("qtype"));
				detail.setName(rs.getString("name"));
				System.out.println(detail.getQcontent());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return  detail;
	 }

	 public int DeleteQ(String qtitle){
		   int flag=0;
		   System.out.println("zheli");
		   try{
			   Connection con=ConnectionFactory.getConnection();
			   String sql="delete from question where qtitle=?";
			   PreparedStatement ps=con.prepareStatement(sql);
			   ps.setString(1,qtitle);
			   flag=ps.executeUpdate();
			   System.out.println(flag);
		   }
		   catch(SQLException e){
				e.printStackTrace();
			}
			return flag;
		    
	   }
	   
	
	
	
	
}
