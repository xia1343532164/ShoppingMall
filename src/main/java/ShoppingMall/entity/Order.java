package ShoppingMall.entity;

import java.util.Date;

public class Order {

	private Integer id;
	private Integer userId;
	private Integer addressId;
	private Integer proId;
	private int   status ;
	private Date ordertime;
	private int paymentMethod;
	private int procount;
	private Long ordernumber;
	
	private User user;
	
	private Commodity commodity;
	
	private VipAddress vipAddress;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public Integer getProId() {
		return proId;
	}
	public void setProId(Integer proId) {
		this.proId = proId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public int getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(int paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public int getProcount() {
		return procount;
	}
	public void setProcount(int procount) {
		this.procount = procount;
	}
	
	
	public Long getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(Long ordernumber) {
		this.ordernumber = ordernumber;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	public VipAddress getVipAddress() {
		return vipAddress;
	}
	public void setVipAddress(VipAddress vipAddress) {
		this.vipAddress = vipAddress;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", addressId=" + addressId + ", proId=" + proId + ", status="
				+ status + ", ordertime=" + ordertime + ", paymentMethod=" + paymentMethod + ", procount=" + procount
				+ ", ordernumber=" + ordernumber + ", user=" + user + ", commodity=" + commodity + ", vipAddress="
				+ vipAddress + "]";
	}

}
