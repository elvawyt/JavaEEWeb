package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.ConnectionFactory;
import vo.ResourceVo;

public class UpdateDao {

	public int InsertResource(ResourceVo reso){
		  int i=0;
		  Connection conn=ConnectionFactory.getConnection();
		  String sql="insert into resource"+
					"(sourcename,sourcecontent,sourcetype,path,sourcepic,name)" +
					" values(?,?,?,?,?,?)";
		  try {
		    System.out.println("testDB");
		    System.out.println(reso.getSourcename());
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,reso.getSourcename());
			pstmt.setString(2,reso.getSourcecontent());
			pstmt.setString(3,reso.getSourcetype());
			pstmt.setString(4,reso.getPath());
			pstmt.setString(5,reso.getSourcepic());
			pstmt.setString(6,reso.getName());
			
			
			 i=pstmt.executeUpdate();
			 System.out.println("testDB");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return i;
	  }
		  
		  
	  }


