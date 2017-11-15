package service;


import vo.RegVo;
import dao.LoginDao;

public class LoginService {
	RegVo user=new RegVo();

	public int getBeliever(RegVo user){
		LoginDao dao=new LoginDao();
		int i=dao.believe(user);
		return i;	
}
	
	public RegVo getDetail(String username){
		RegVo user = new RegVo();
		LoginDao dao = new LoginDao();
		user= dao.selectById(username);
		return user;
	}
}
