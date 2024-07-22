package com.anurag.jpaPractice.jpaPactice.repositories;

import com.anurag.jpaPractice.jpaPactice.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {


}
