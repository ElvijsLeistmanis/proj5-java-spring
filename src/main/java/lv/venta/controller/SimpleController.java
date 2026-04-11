package lv.venta.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Product;
import lv.venta.model.ProductType;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/simple")
public class SimpleController {
	
	@GetMapping("/page") //localhost:8080/simple/page
	public String getShowPage() {
		return "show-page"; //show-page.html is shown, html files are put in templates
	}
	
	@GetMapping("/data")
	public String getDataInPage(Model model) {
		Random rand = new Random();
		String data = "@Elvijs " + rand.nextInt(1, 1000);
		model.addAttribute("package", data);
		return "show-data-page";
	}
	
	@GetMapping("/product")
	public String getProductInPage(Model model) {
		Product product = new Product("Banana", 3.5f, 25, ProductType.fruit);
		model.addAttribute("package", product);
		return "show-product-page";
	}
	
	@GetMapping("/multiProduct")
	public String getMultipleProduct(Model model) {
		Product product1 = new Product("Banana", 3.5f, 25, ProductType.fruit);
		Product product2 = new Product("Apple", 2.5f, 15, ProductType.fruit);
		Product product3 = new Product("Kiwi", 5.5f, 5, ProductType.fruit);
		ArrayList<Product> productList = new ArrayList<Product>();
		productList.addAll(Arrays.asList(product1, product2, product3));
		model.addAttribute("package", productList);
		return "show-product-list-page";
	}
	
	@GetMapping("/add")
	public String getAddNewProduct(Model model) {
		model.addAttribute("product", new Product());
		return "add-new-product-page";
	}
	
	@PostMapping("/add")
	public String postAddNewProduct(Product product) {
		System.out.println(product);
		return "redirect:/simple/multiProduct";
	}
	
}
