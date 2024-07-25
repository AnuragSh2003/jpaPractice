package com.anurag.jpaPractice.jpaPactice;

import com.anurag.jpaPractice.jpaPactice.entities.ProductEntity;
import com.anurag.jpaPractice.jpaPactice.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

	@Test
	void getRepository(){

		// creating custom Data query methods just by giving name and Spring Data JPA make that method happen.
//		List<ProductEntity> entities = productRepository.findByTitle("Pepsi");
//		System.out.println(entities);

//		List<ProductEntity> entities1 = productRepository.findByCreatedAtAfter(LocalDateTime.of(2024,1,1,0,0,0));
//		System.out.println(entities1);

//		List<ProductEntity> entities = productRepository.findByQuantityAndPrice(4,BigDecimal.valueOf(14.40));
//		System.out.println(entities);

//		List<ProductEntity> entities = productRepository.findByQuantityGreaterThanAndPriceLessThan(4,BigDecimal.valueOf(13.4));
//		System.out.println(entities);

		List<ProductEntity> entities =productRepository.findByTitleLike("%Choco%");

		List<ProductEntity> entities1 =productRepository.findByTitleContainingIgnoreCase("%Choco%",null);
		System.out.println(entities1);

	}

	@Test
	void getSingleFromRepository(){
		Optional<ProductEntity> entity = productRepository.findByTitleAndPrice("Mango", BigDecimal.valueOf(14.40));
		System.out.println(entity);
	}


}
