package vo;

public class RegVo {
   private String username;
   private String password;
   private String role;
   private String name;
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
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public RegVo(String username, String password) {
	super();
	this.username = username;
	this.password = password;
}
public RegVo(String username) {
	super();
	this.username = username;
}
public RegVo() {
	super();
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public RegVo(String username, String password, String role) {
	super();
	this.username = username;
	this.password = password;
	this.role = role;
}
public String getRank() {
	return rank;
}
public void setRank(String rank) {
	this.rank = rank;
}

   
   
}
