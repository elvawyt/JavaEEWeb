package service;

import java.util.ArrayList;

import vo.AnswerVo;
import vo.AskVo;
import dao.AnswerDao;

public class AnswerService {
	AnswerVo ans= new AnswerVo();
    public int InsertAnswer(AnswerVo ans){
    	
        	AnswerDao dao= new AnswerDao();
        	int i=dao.InsertA(ans);
        	return i;
    	
    }
    public ArrayList<AnswerVo> ShowAnswer(String qtitle){
    	ArrayList<AnswerVo> list=new ArrayList<AnswerVo>();
    	AnswerDao dao=new AnswerDao();
    	list=dao.ShowA(qtitle);
		return list;
    	
    }
}
