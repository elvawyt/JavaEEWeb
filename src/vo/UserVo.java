package vo;

public class UserVo {
    private String name;
    private String username;
    private String sex;
    private String phone;
    private String pic;
    private String hobby1;
    private String hobby2;
    private String hobby3;
    private String rank;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getHobby1() {
		return hobby1;
	}
	public void setHobby1(String hobby1) {
		this.hobby1 = hobby1;
	}
	public String getHobby2() {
		return hobby2;
	}
	public void setHobby2(String hobby2) {
		this.hobby2 = hobby2;
	}
	public String getHobby3() {
		return hobby3;
	}
	public void setHobby3(String hobby3) {
		this.hobby3 = hobby3;
	}
	public UserVo(String name, String username, String sex, String phone,
			String pic, String hobby1, String hobby2, String hobby3) {
		super();
		this.name = name;
		this.username = username;
		this.sex = sex;
		this.phone = phone;
		this.pic = pic;
		this.hobby1 = hobby1;
		this.hobby2 = hobby2;
		this.hobby3 = hobby3;
	}
	public UserVo() {
		super();
	}
	public UserVo(String name, String username, String sex, String phone) {
		super();
		this.name = name;
		this.username = username;
		this.sex = sex;
		this.phone = phone;
	}
	public UserVo(String name, String username, String sex, String phone,
			String pic) {
		super();
		this.name = name;
		this.username = username;
		this.sex = sex;
		this.phone = phone;
		this.pic = pic;
	}
	public UserVo(String name, String username, String sex, String phone,
			String pic, String hobby1) {
		super();
		this.name = name;
		this.username = username;
		this.sex = sex;
		this.phone = phone;
		this.pic = pic;
		this.hobby1 = hobby1;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public UserVo(String name, String username, String rank) {
		super();
		this.name = name;
		this.username = username;
		
		this.rank = rank;
	}
    
	
    
}
