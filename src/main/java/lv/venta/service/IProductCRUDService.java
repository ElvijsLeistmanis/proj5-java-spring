package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Product;
import lv.venta.model.ProductType;

public interface IProductCRUDService {
	void createProduct(String name, float price, int description, ProductType producttype) throws Exception;
	
	Product retrieveProductById(int id) throws Exception;
	
	ArrayList<Product> retrieveAllProduct() throws Exception;
	
	void updateProductById(String name, float price, int description, ProductType producttype, int id) throws Exception;
	
	void deleteProductById(int id) throws Exception;
}