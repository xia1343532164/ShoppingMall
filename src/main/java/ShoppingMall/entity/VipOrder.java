package ShoppingMall.entity;

import java.util.Date;

public class VipOrder {

	private Integer id;
	private Integer user_id;
	private Integer address_id;
	private int   status ;
	private Date ordertime;
	private int paymentMethod;
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
	public Integer getAddress_id() {
		return address_id;
	}
	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
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
	@Override
	public String toString() {
		return "VipOrder [id=" + id + ", user_id=" + user_id + ", address_id=" + address_id + ", status=" + status
				+ ", ordertime=" + ordertime + ", paymentMethod=" + paymentMethod + "]";
	}
}
