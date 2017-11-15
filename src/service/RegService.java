package service;

import dao.RegDao;
import vo.RegVo;



public class RegService {
	RegVo user=new RegVo(); //reg是vo包里的，user是reg的对象
	public int RegistUser(RegVo user){ 
		RegDao dao=new RegDao(); // dao是dao包里的
		int i=dao.InsertUser(user);// insertUser是dao包里的
		return i;
	}
}
