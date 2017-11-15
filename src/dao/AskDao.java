package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.ConnectionFactory;
import vo.AskVo;


public class AskDao {
	public int InsertQ(AskVo ask){
		  int i=0;
		  Connection conn=ConnectionFactory.getConnection();
		  String sql="insert into question"+
					"(qtitle,qcontent,qtype,name)" +
					" values(?,?,?,?)";
		  try {
			  System.out.println("testDB");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,ask.getQtitle());
			pstmt.setString(2,ask.getQcontent());
			pstmt.setString(3,ask.getQtype());
			pstmt.setString(4,ask.getName());
			
			
			 i=pstmt.executeUpdate();
			 System.out.println("testDB");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return i;
	  }
		  
		  
	  }

