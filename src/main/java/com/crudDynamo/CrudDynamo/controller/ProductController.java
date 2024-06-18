package com.crudDynamo.CrudDynamo.controller;

import com.crudDynamo.CrudDynamo.model.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import com.crudDynamo.CrudDynamo.service.BL.ProductServiceBL;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/products")
@Slf4j
public class ProductController {

    private final ProductServiceBL productServiceBL;

    public ProductController(ProductServiceBL productServiceBL) {
        this.productServiceBL = productServiceBL;
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        log.info("Fetching all products");
        return productServiceBL.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable String id) {
        log.info("Fetching product by id: {}", id);
        return productServiceBL.getProductById(id);
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        log.info("Creating new product: {}", productDTO);
        return productServiceBL.createNewProduct(productDTO);
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable String id, @RequestBody ProductDTO productDTO) {
        log.info("Updating product with id {}: {}", id, productDTO);
        return productServiceBL.updateProduct(id, productDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        log.info("Deleting product with id: {}", id);
        productServiceBL.deleteProduct(id);
    }

}