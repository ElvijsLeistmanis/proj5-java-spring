package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import lv.venta.model.Product;
import lv.venta.model.ProductType;
import lv.venta.repo.IProductRepo;
import lv.venta.service.IProductCRUDService;

@Service
public class ProductCRUDServiceImpl implements IProductCRUDService{

	private IProductRepo prodRepo;
	
	@Override
	public void createProduct(String name, float price, int description, ProductType producttype) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product retrieveProductById(long id) throws Exception {
		if (id < 0) throw new Exception("ID Cannot be negative.");
		if (!prodRepo.existsById(id)) throw new Exception("No product with given ID exists.");
		
		return prodRepo.findById(id).get();
	}

	@Override
	public ArrayList<Product> retrieveAllProduct() throws Exception {
		if(prodRepo.count() == 0) throw new Exception("Product DB is empty.");
		
		return (ArrayList<Product>) prodRepo.findAll();
	}

	@Override
	public void updateProductById(String name, float price, int description, ProductType producttype, int id)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProductById(long id) throws Exception {
		if (id < 0) throw new Exception("ID Cannot be negative.");
		if (!prodRepo.existsById(id)) throw new Exception("No product with given ID exists.");
		
		prodRepo.deleteById(id);
	}

}
