package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Product;
import lv.venta.model.ProductType;

public interface IProductRepo extends CrudRepository<Product, Long>{
	boolean existsByNameAndPriceAndProducttype(String name, float price, ProductType producttype);
}
