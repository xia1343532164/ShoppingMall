package ShoppingMall.entity;

public class Car {

	private Integer id;
	private Integer userId;
	private Integer proId;
	private int goodscount;
	
	private Commodity commoditys;
	private User user;
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
	public Integer getProId() {
		return proId;
	}
	public void setProId(Integer proId) {
		this.proId = proId;
	}
	public int getGoodscount() {
		return goodscount;
	}
	public void setGoodscount(int goodscount) {
		this.goodscount = goodscount;
	}
	public Commodity getCommoditys() {
		return commoditys;
	}
	public void setCommoditys(Commodity commoditys) {
		this.commoditys = commoditys;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", userId=" + userId + ", proId=" + proId + ", goodscount=" + goodscount
				+ ", commoditys=" + commoditys + ", user=" + user + "]";
	}

}
