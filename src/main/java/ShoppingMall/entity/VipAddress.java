package ShoppingMall.entity;

public class VipAddress {
	private Integer id ;
	private Integer user_id;
	private String zone;//地区
	private String address;//地址
	private String code;//邮政编码
	private String addressee ;//收件人
	private String mobilephone;//手机号码或固定电话
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAddressee() {
		return addressee;
	}
	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}
	public String getMobilephone() {
		return mobilephone;
	}
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	

	@Override
	public String toString() {
		return "VipAddress [id=" + id + ", user_id=" + user_id + ", zone=" + zone + ", address=" + address + ", code="
				+ code + ", addressee=" + addressee + ", mobilephone=" + mobilephone + "]";
	}
}
