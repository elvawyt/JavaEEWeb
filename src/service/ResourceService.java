package service;

import java.util.ArrayList;

import dao.ResourceDao;
import vo.ResourceVo;

public class ResourceService {
    public ArrayList<ResourceVo> ShowReso(){
    	ResourceDao dao=new ResourceDao();
    	ArrayList<ResourceVo> list=dao.selectAll();
		return list;
    	
    }
    
    public int ChangeP(String sourcename){
		int i;
		ResourceDao dao=new ResourceDao();
		i=dao.Update(sourcename);
    	return i;
    	
    }
    
    public int AgreeU(String sourcename){
		int i;
		ResourceDao dao=new ResourceDao();
		i=dao.Agree(sourcename);
    	return i;
    	
    }
    
    
    
}
