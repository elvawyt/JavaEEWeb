package vo;

public class AskVo {
	   private String qtitle;
	   private String qcontent;
	   private String qtype;
	   private String name;
	   private String qstatus;
	public String getQtitle() {
		return qtitle;
	}
	public void setQtitle(String qtitle) {
		this.qtitle = qtitle;
	}
	public String getQcontent() {
		return qcontent;
	}
	public void setQcontent(String qcontent) {
		this.qcontent = qcontent;
	}
	public String getQtype() {
		return qtype;
	}
	public void setQtype(String qtype) {
		this.qtype = qtype;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQstatus() {
		return qstatus;
	}
	public void setQstatus(String qstatus) {
		this.qstatus = qstatus;
	}
	public AskVo() {
		super();
	}
	public AskVo(String qtitle, String qcontent, String qtype, String name) {
		super();
		this.qtitle = qtitle;
		this.qcontent = qcontent;
		this.qtype = qtype;
		this.name = name;
	}
	
	
	   
}
