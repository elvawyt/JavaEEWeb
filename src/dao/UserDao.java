package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionFactory;
import vo.AskVo;
import vo.UserVo;

public class UserDao {
  public int InsertU(UserVo user){
	  int i=0;
	  Connection conn=ConnectionFactory.getConnection();
	  String sql="insert into user"+
				"(name,sex,phone,pic,username,lable1)" +
				" values(?,?,?,?,?,?)";
	  try {
		  System.out.println("testDB");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,user.getName());
		pstmt.setString(2,user.getSex());
		pstmt.setString(3,user.getPhone());
		pstmt.setString(4,user.getPic());
		pstmt.setString(5,user.getUsername());
		pstmt.setString(6,user.getHobby1());
		
		
		
		 i=pstmt.executeUpdate();
		 System.out.println("testDB");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return i;
  }
	  
  public ArrayList<UserVo> selectAll()
	{
		ArrayList<UserVo> list=new ArrayList<UserVo>();
		try {
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from user;");
			ResultSet rs=ps.executeQuery();//Ö´ÐÐ
			while(rs.next()){
				UserVo user=new UserVo(rs.getString("name"),rs.getString("username"),rs.getString("rank"));
			list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
  
  
   public int ChangeU(String username){
	   int num=0;
		try{
			Connection con=ConnectionFactory.getConnection();
			String sql="update user set rank='vip' where username=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,username);
			
			num=ps.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return num;}
   
   public int DeleteU(String username){
	   int flag=0;
	   try{
		   Connection con=ConnectionFactory.getConnection();
		   String sql="delete from user where username=?";
		   PreparedStatement ps=con.prepareStatement(sql);
		   ps.setString(1,username);
		   flag=ps.executeUpdate();
	   }
	   catch(SQLException e){
			e.printStackTrace();
		}
		return flag;
	    
   }
   
	  
  }

