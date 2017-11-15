package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionFactory;
import vo.ResourceVo;
import vo.UserVo;

public class ResourceDao {
	public ArrayList<ResourceVo> selectAll()
	{
		ArrayList<ResourceVo> list=new ArrayList<ResourceVo>();
		try {
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from resource;");
			ResultSet rs=ps.executeQuery();//Ö´ÐÐ
			while(rs.next()){
				ResourceVo reso=new ResourceVo(rs.getString("sourcename"),rs.getString("sourcecontent"),rs.getInt("dlnumber"),rs.getInt("permission"),rs.getString("path"),rs.getString("sourcetype"),rs.getString("name"),rs.getString("sourcepic"));
			list.add(reso);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
}
	
	
	
	public int Update(String sourcename){
		int num=0;
		try{
			Connection con=ConnectionFactory.getConnection();
			String sql="update resource set permission='1' where sourcename=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,sourcename);
			
			num=ps.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return num;
	}
	
	public int Agree(String sourcename){
		int num=0;
		try{
			Connection con=ConnectionFactory.getConnection();
			String sql="update resource set dlnumber='1' where sourcename=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,sourcename);
			
			num=ps.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return num;
	}
	
}
