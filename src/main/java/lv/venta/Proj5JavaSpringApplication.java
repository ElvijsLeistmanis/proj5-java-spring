package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Product;
import lv.venta.model.ProductType;
import lv.venta.repo.IProductRepo;

@SpringBootApplication
public class Proj5JavaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proj5JavaSpringApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner testRepo(IProductRepo repo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Product product1 = new Product("Banana", 3.5f, 25, ProductType.fruit);
				Product product2 = new Product("Apple", 2.5f, 15, ProductType.fruit);
				Product product3 = new Product("Kiwi", 5.5f, 5, ProductType.fruit);
				
				repo.save(product1);
				repo.save(product2);
				repo.save(product3);
				
				
			}
		};
	}

}
