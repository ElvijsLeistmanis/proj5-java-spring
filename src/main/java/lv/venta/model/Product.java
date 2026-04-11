package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name="ProductTable")
@Entity
public class Product {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name="Id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Price")
	private float price;
	
	@Column(name="Quantity")
	private int quantity;
	
	@Column(name="ProductType")
	private ProductType producttype;
	
	public Product(String name, float price, int quantity, ProductType producttype) {
		setName(name);
		setPrice(price);
		setQuantity(quantity);
		setProducttype(producttype);
	}
}
