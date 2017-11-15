package service;

import java.util.ArrayList;

import dao.UserDao;
import vo.UserVo;

public class UserService {
    UserVo user= new UserVo();
    public int RegisterU(UserVo user){
    	UserDao dao= new UserDao();
    	int i=dao.InsertU(user);
    	return i;
    	
    }
    
    public ArrayList<UserVo> ShowUser(){
		UserDao dao= new UserDao();
		ArrayList<UserVo> list= dao.selectAll();  	
    	return list;
    	
    }
    
    public int ChangeRank(String username){
    	
    	 UserDao dao= new UserDao();
    	 int i=dao.ChangeU(username);
    	 return i;
    	 
    }
    
    public int deleteUser(String username){
    	UserDao dao = new UserDao();
    	int i=dao.DeleteU(username);
    	return i;
    	
    }
}
