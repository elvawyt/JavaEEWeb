package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionFactory;
import vo.AnswerVo;
import vo.AskVo;

public class AnswerDao {
	public int InsertA(AnswerVo ans){
		  int i=0;
		  Connection conn=ConnectionFactory.getConnection();
		  String sql="insert into answer"+
					"(acontent,agree,qtitle,name)" +
					" values(?,?,?,?)";
		  try {
			System.out.println("dao²ã");
			System.out.println(ans.getQtitle());
			System.out.println(ans.getAcontent());
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,ans.getAcontent());
			pstmt.setString(2,ans.getAgree());
			pstmt.setString(3,ans.getQtitle());
			pstmt.setString(4,ans.getName());
			
			
			 i=pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return i;
	  }
	
	
	
	public ArrayList<AnswerVo> ShowA(String qtitle){
		ArrayList<AnswerVo> list=new ArrayList<AnswerVo>();
		try {
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from answer where qtitle='"+qtitle+"'");
			ResultSet rs=ps.executeQuery();//Ö´ÐÐ
			while(rs.next()){
				AnswerVo an =new AnswerVo(rs.getString("acontent"),rs.getString("agree"),rs.getString("qtitle"),rs.getString("name"));
			list.add(an);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	 
		
	}
}
