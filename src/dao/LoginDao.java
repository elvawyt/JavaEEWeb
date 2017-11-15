package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.ConnectionFactory;

import vo.RegVo;


public class LoginDao {
	public int believe(RegVo user){
		 int i=0;
		 Connection conn=ConnectionFactory.getConnection();
			
		 try {
			PreparedStatement st=null;
			String sql="select * from reg where username='"+user.getUsername()+"' and  password='"+user.getPassword()+"'";
	 		st = conn.prepareStatement(sql);
			ResultSet rs =st.executeQuery(sql);
			if(rs.next()==true){
	 			i=1;
			}else{
	 			i=0;
			}
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return i;
	}
	
	

	 public RegVo selectById(String username){
		 RegVo user=new RegVo();
		 Connection conn=ConnectionFactory.getConnection();
		 try {
			String sql="select username,password,role from reg where username='"+username+"'";
			PreparedStatement state=conn.prepareStatement(sql);
			String name="select name,rank from user where username='"+username+"'";
			PreparedStatement hehe=conn.prepareStatement(name);
			
			ResultSet rs=state.executeQuery();
			ResultSet ab=hehe.executeQuery();
			if(rs.next()&& ab.next()){
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				user.setName(ab.getString("name"));
				user.setRank(ab.getString("rank"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("this is dao");
		 System.out.println(user.getRank());
		return  user;
	 }


}
