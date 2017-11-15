package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.ConnectionFactory;
import vo.RegVo;


public class RegDao {
	 public int InsertUser(RegVo user){
		  int i=0;
		  String role=user.getRole();
		  System.out.println(role);
		  Connection conn=ConnectionFactory.getConnection();
		  
		  String sql="insert into reg"+
					"(username,password,role)" +
					" values(?,?,?)";
		  try {
			  System.out.println("testDB");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,user.getUsername());
			pstmt.setString(2,user.getPassword());
			pstmt.setString(3, user.getRole());
			
			i=pstmt.executeUpdate();
			 System.out.println("testDB");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return i;
	  }
	 
}
