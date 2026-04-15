package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Product;
import lv.venta.model.ProductType;

public interface IProductCRUDService {
	void createProduct(String name, float price, int description, ProductType producttype) throws Exception;
	
	Product retrieveProductById(long id) throws Exception;
	
	ArrayList<Product> retrieveAllProduct() throws Exception;
	
	void updateProductById(String name, float price, int description, ProductType producttype, long id) throws Exception;
	
	void deleteProductById(long id) throws Exception;
}