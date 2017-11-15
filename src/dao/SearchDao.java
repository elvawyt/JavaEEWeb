package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionFactory;
import vo.ResourceVo;

public class SearchDao {
	public ArrayList<ResourceVo> selectResource(String key){
			ArrayList<ResourceVo> list=new ArrayList<ResourceVo>();
			try {
				Connection conn=ConnectionFactory.getConnection();
				String sql="select * from resource where sourcename like '%"+key+"%';";
				PreparedStatement pst=conn.prepareStatement(sql);
				ResultSet rs=pst.executeQuery();
				while(rs.next()){
				ResourceVo resource=new ResourceVo(rs.getString("sourcename"),rs.getString("sourcecontent"),rs.getInt("dlnumber"),rs.getInt("permission"),rs.getString("path"),rs.getString("sourcetype"),rs.getString("name"),rs.getString("sourcepic"));
				System.out.println(resource.getName());
				System.out.println(resource.getSourcename());
				System.out.println("ddddddd");
					list.add(resource);			
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
	}

	
	public ArrayList<ResourceVo> selectResourceType(String key){
		ArrayList<ResourceVo> list=new ArrayList<ResourceVo>();
		try {
			Connection conn=ConnectionFactory.getConnection();
			String sql="select * from resource where sourcetype like '%"+key+"%';";
			PreparedStatement pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
			ResourceVo resource=new ResourceVo(rs.getString("sourcename"),rs.getString("sourcecontent"),rs.getInt("dlnumber"),rs.getInt("permission"),rs.getString("path"),rs.getString("sourcetype"),rs.getString("name"),rs.getString("sourcepic"));
			
				list.add(resource);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
}

}
