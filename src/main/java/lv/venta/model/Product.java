package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Z]{1}[a-z ]{2,30}")
	private String name;
	
	@Column(name="Price")
	@Min(0)
	@Max(1000)
	private float price;
	
	@Column(name="Quantity")
	@Min(0)
	@Max(1000)
	private int quantity;
	
	@Column(name="ProductType")
	@NotNull
	private ProductType producttype;
	
	public Product(String name, float price, int quantity, ProductType producttype) {
		setName(name);
		setPrice(price);
		setQuantity(quantity);
		setProducttype(producttype);
	}
}
