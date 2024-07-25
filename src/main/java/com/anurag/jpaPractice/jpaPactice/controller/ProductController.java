package com.anurag.jpaPractice.jpaPactice.controller;

import com.anurag.jpaPractice.jpaPactice.entities.ProductEntity;
import com.anurag.jpaPractice.jpaPactice.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    private  final  int PAGE_SIZE = 5;
    private  final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    @GetMapping
//    public List<ProductEntity> getAllProduct(@RequestParam(defaultValue = "id")  String sortBy){
//        return productRepository.findBy(Sort.by(sortBy));
//    }

    @GetMapping
    public List<ProductEntity> getAllProduct(
            @RequestParam(defaultValue = "")String title,
            @RequestParam(defaultValue = "id")  String sortBy,
            @RequestParam(defaultValue = "0 ")  Integer pageNumber
            ){
//        return productRepository.findBy(Sort.by(Sort.Direction.DESC, sortBy,"price"));
            return  productRepository.findByTitleContainingIgnoreCase(
                    title,
                    PageRequest.of(pageNumber,PAGE_SIZE,Sort.by(sortBy))
            );
//        Pageable pageable = PageRequest.of(
//                pageNumber,
//                PAGE_SIZE,
//                Sort.by(sortBy));
//
//        return  productRepository.findAll(pageable).getContent();
    }
}
