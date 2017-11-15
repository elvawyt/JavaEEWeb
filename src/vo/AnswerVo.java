package vo;

public class AnswerVo {
	   private String acontent;
	   private String agree;
	   private String qtitle;
	   private String name;
	public String getAcontent() {
		return acontent;
	}
	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}
	public String getAgree() {
		return agree;
	}
	public void setAgree(String agree) {
		this.agree = agree;
	}
	public String getQtitle() {
		return qtitle;
	}
	public void setQtitle(String qtitle) {
		this.qtitle = qtitle;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AnswerVo(String acontent, String agree, String qtitle, String name) {
		super();
		this.acontent = acontent;
		this.agree = agree;
		this.qtitle = qtitle;
		this.name = name;
	}
	public AnswerVo() {
		super();
	}
	public AnswerVo(String acontent, String agree, String name) {
		super();
		this.acontent = acontent;
		this.agree = agree;
		this.name = name;
	}
	   
	   
}
