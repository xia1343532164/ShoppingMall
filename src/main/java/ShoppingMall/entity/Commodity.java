package ShoppingMall.entity;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Commodity {

	private Integer id;
	private String title;
	private String picturePath;
    private String classify;
    private String price;
    private String stock;
    private String introduce;
    private MultipartFile picture;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public MultipartFile getPicture() {
		return picture;
	}
	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}
	@Override
	public String toString() {
		return "Commodity [id=" + id + ", title=" + title + ", picturePath=" + picturePath + ", classify=" + classify
				+ ", price=" + price + ", stock=" + stock + ", introduce=" + introduce + ", picture=" + picture;
	}
}
