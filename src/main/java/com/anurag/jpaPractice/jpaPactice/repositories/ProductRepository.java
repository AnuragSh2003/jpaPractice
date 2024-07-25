package com.anurag.jpaPractice.jpaPactice.repositories;

import com.anurag.jpaPractice.jpaPactice.entities.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {


//    List<ProductEntity> findByTitleOrderByPrice(String title);
    List<ProductEntity> findByTitle(String title, Pageable pageable);

//    List<ProductEntity> findByOrderByPrice();
    List<ProductEntity> findBy(Sort sort);
    List<ProductEntity> findByCreatedAtAfter(LocalDateTime after);

    List<ProductEntity> findByQuantityAndPrice(int i, BigDecimal bigDecimal);

    List<ProductEntity> findByQuantityGreaterThanAndPriceLessThan(int i, BigDecimal bigDecimal);

    List<ProductEntity> findByTitleLike(String title);

    List<ProductEntity> findByTitleContaining(String title);

    List<ProductEntity> findByTitleContainingIgnoreCase(String title,Pageable pageable);

   // Optional<ProductEntity> findByTitleAndPrice(String title,BigDecimal price);

    @Query("select e from ProductEntity e where e.title=?1 and e. price=?2")
    Optional<ProductEntity> findByTitleAndPrice(String title,BigDecimal price);
}
