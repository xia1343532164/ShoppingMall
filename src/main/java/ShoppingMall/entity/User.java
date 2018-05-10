package ShoppingMall.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

	private Integer id;
	@Size(min = 2,max = 16 ,message="�û���������2~16����")
	private String username;
	
	@Size(min = 6 ,max = 64 ,message="���볤��Ϊ6~64")
	private String password;
	
	@Pattern(regexp="^1[3|4|5|7|8][0-9]{9}$",message="�ֻ��Ų����Ϲ���")
	private String phone;
	
	private String role;
	
	@Email(regexp="^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$",message="����Ų����Ϲ���")
	private String email;
	
	private String realname;
	private String city;
	private String sex;
	private String idcard;
	private String category;
	private String sysopsis;
				   
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSysopsis() {
		return sysopsis;
	}
	public void setSysopsis(String sysopsis) {
		this.sysopsis = sysopsis;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", phone=" + phone + ", role="
				+ role + ", email=" + email + ", realname=" + realname + ", city=" + city + ", sex=" + sex + ", idcard="
				+ idcard + ", category=" + category + ", sysopsis=" + sysopsis + "]";
	}
	
}
