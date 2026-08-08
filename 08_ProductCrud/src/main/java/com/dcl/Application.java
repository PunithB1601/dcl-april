package com.dcl;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.dcl.entity.Product;
import com.dcl.repo.ProductRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(Application.class, args);
		ProductRepo prepo=context.getBean(ProductRepo.class);
		
		Product p1=new Product(1,"Watch",5000.0,"Titan","Watch");
		Product p2=new Product(2,"SmartWatch",3000.0,"Fastrack","Watch");
		Product p3=new Product(3,"SportShoes",2000.0,"Adidas","Shoes");
		Product p4=new Product(4,"Loafers",1500.0,"Puma","Shoes");
		Product p5=new Product(5,"iPhone",50000.0,"Apple","Phone");
		Product p6=new Product(6,"Samsung s25",125000.0,"Samsung","Phone");
		Product p7=new Product(7,"iWatch",30000.0,"Apple","Watch");
		Product p8=new Product(8,"FormalShoe",2000.0,"Bata","Shoes");
		Product p9=new Product(9,"Loafers",1500.0,"Adidas","Shoes");
		Product p10=new Product(10,"iPhone 17 pro",150000.0,"Apple","Phone");
		
		//prepo.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10));
		
		//Sorting
		//Sort s=Sort.by("price").descending();
		
		//Pageable page=PageRequest.of(4-1,4);
		
		Product p=new Product();
		p.setProdName("T-Shirt");
		p.setBrand("Puma");
		p.setCategory("Shirt");
		p.setPrice(1000.0);
		prepo.save(p);
		
		//Example<Product> example=Example.of(p);
		
		//prepo.findAll(example).forEach(System.out::println);
		
	}

}
