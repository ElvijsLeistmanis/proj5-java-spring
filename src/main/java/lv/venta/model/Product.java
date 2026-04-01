package lv.venta.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
@Getter
@Setter
@NoArgsConstructor
@ToString
*/
public class Product {
	
	private long id;
	private String name;
	private float price;
	private int quantity;
	private ProductType producttype;
	private long count = 0;
	
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public ProductType getProducttype() {
		return producttype;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setProducttype(ProductType producttype) {
		this.producttype = producttype;
	}

	public Product() {
		setName("Product");
		setPrice(0);
		setQuantity(0);
		setProducttype(ProductType.unknown);
		id = count++;
	}
	
	public Product(String name, float price, int quantity, ProductType producttype) {
		setName(name);
		setPrice(price);
		setQuantity(quantity);
		setProducttype(producttype);
		id = count++;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", producttype="
				+ producttype + "]";
	}
}
