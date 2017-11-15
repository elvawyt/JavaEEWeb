package service;

import vo.AskVo;
import dao.AskDao;

public class AskService {
	AskVo ask= new AskVo();
    public int AskQ(AskVo ask){
    	AskDao dao= new AskDao();
    	int i=dao.InsertQ(ask);
    	return i;
    	
    }
    
}
