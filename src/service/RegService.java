package service;

import dao.RegDao;
import vo.RegVo;



public class RegService {
	RegVo user=new RegVo(); //reg��vo����ģ�user��reg�Ķ���
	public int RegistUser(RegVo user){ 
		RegDao dao=new RegDao(); // dao��dao�����
		int i=dao.InsertUser(user);// insertUser��dao�����
		return i;
	}
}
