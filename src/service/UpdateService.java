package service;

import vo.ResourceVo;
import dao.UpdateDao;

public class UpdateService {
   ResourceVo reso= new ResourceVo();
   public int UpdateS(ResourceVo reso){
	    UpdateDao dao = new UpdateDao();
	    int i =dao.InsertResource(reso);
	    return i;
   }
}
