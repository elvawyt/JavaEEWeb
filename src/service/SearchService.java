package service;

import java.util.ArrayList;

import dao.SearchDao;
import vo.ResourceVo;

public class SearchService {
	public ArrayList<ResourceVo> selectResource(String key){
		SearchDao dao=new SearchDao();
		ArrayList<ResourceVo> list=dao.selectResource(key);
		return list;
		
	}
	public ArrayList<ResourceVo> selectResourceType(String key){
		SearchDao dao=new SearchDao();
		ArrayList<ResourceVo> list=dao.selectResourceType(key);
		return list;
		
	}

}
