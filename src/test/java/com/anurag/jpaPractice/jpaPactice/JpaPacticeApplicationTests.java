package com.anurag.jpaPractice.jpaPactice;

import com.anurag.jpaPractice.jpaPactice.entities.ProductEntity;
import com.anurag.jpaPractice.jpaPactice.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class JpaPacticeApplicationTests {

	@Autowired
	ProductRepository productRepository;
	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){
		ProductEntity productEntity = ProductEntity.builder()
				.sku("nestler23")
				.title("Nestle Chocolate")
				.price(BigDecimal.valueOf(123.45))
				.quantity(12)
				.build();


		ProductEntity saveProductEntity =  productRepository.save(productEntity);
		System.out.println(saveProductEntity);
	}
}
