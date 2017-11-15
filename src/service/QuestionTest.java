package service;

import java.util.ArrayList;

import dao.QuestionDao;
import vo.AskVo;

public class QuestionTest {
	public ArrayList<AskVo> selectQuestion(){
		QuestionDao dao=new QuestionDao();
		ArrayList<AskVo> list=dao.selectAll();
		return list;}
		

		/*ArrayList<AskVo> list=new ArrayList<AskVo>();
		list=dao.selectAll();
		return list;*/
	public AskVo selectDetail(String title){
		QuestionDao dao=new QuestionDao();
		AskVo detail=dao.selectDetail(title);
		return detail;}
	
	public int DeleteQuestion(String qtitle){
		QuestionDao dao= new QuestionDao();
		int i=dao.DeleteQ(qtitle);
		return i;
	}

}
