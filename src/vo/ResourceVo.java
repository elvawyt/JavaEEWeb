package vo;

public class ResourceVo {
	    private String sourcename;
	    private String sourcecontent;
	    private Integer dlnumber;
	    private Integer permission;
	    private String path;
	    private String sourcetype;
	    private String name;
	    private String sourcepic;
	    
	    
		public String getSourcename() {
			return sourcename;
		}
		public void setSourcename(String sourcename) {
			this.sourcename = sourcename;
		}
		public String getSourcecontent() {
			return sourcecontent;
		}
		public void setSourcecontent(String sourcecontent) {
			this.sourcecontent = sourcecontent;
		}
		public Integer getDlnumber() {
			return dlnumber;
		}
		public void setDlnumber(Integer dlnumber) {
			this.dlnumber = dlnumber;
		}
		public Integer getPermission() {
			return permission;
		}
		public void setPermission(Integer permission) {
			this.permission = permission;
		}
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}
		public String getSourcetype() {
			return sourcetype;
		}
		public void setSourcetype(String sourcetype) {
			this.sourcetype = sourcetype;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSourcepic() {
			return sourcepic;
		}
		public void setSourcepic(String sourcepic) {
			this.sourcepic = sourcepic;
		}
		public ResourceVo(String sourcename, String sourcecontent, String path,
				String sourcetype, String name, String sourcepic) {
			super();
			this.sourcename = sourcename;
			this.sourcecontent = sourcecontent;
			this.path = path;
			this.sourcetype = sourcetype;
			this.name = name;
			this.sourcepic = sourcepic;
		}
		public ResourceVo() {
			super();
		}
		public ResourceVo(String sourcename, String sourcecontent,
				Integer dlnumber, Integer permission, String path,
				String sourcetype, String name, String sourcepic) {
			super();
			this.sourcename = sourcename;
			this.sourcecontent = sourcecontent;
			this.dlnumber = dlnumber;
			this.permission = permission;
			this.path = path;
			this.sourcetype = sourcetype;
			this.name = name;
			this.sourcepic = sourcepic;
		}
		public ResourceVo(String sourcename, Integer permission, String name) {
			super();
			this.sourcename = sourcename;
			this.permission = permission;
			this.name = name;
		}
		public ResourceVo(String sourcename, Integer dlnumber,
				Integer permission, String name) {
			super();
			this.sourcename = sourcename;
			this.dlnumber = dlnumber;
			this.permission = permission;
			this.name = name;
		}
	    
		
	    
	    
}