package jsonUtils.invoices;

import java.util.List;

public class Products {

	public String productId;
	public String productName;
	public String brand;
	public double price;
	public Specifications specifications;
	public List<Reviews> reviews;

	public List<Reviews> getReviews() {
		return reviews;
	}

	public void setReviews(List<Reviews> reviews) {
		this.reviews = reviews;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Specifications getSpecifications() {
		return specifications;
	}

	public void setSpecifications(Specifications specifications) {
		this.specifications = specifications;
	}

	public String toString() {
		return getProductId() + " " + getProductName() + " " + getBrand() + " " + getPrice() + " "
				+ getSpecifications();
	}

}
