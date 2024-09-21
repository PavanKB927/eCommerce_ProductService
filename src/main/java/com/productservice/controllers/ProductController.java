package com.productservice.controllers;

import com.productservice.dtos.GenericProductDto;
import com.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public GenericProductDto getProduct(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/")
    public List<GenericProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/")
    public GenericProductDto createProduct(@RequestBody GenericProductDto product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public GenericProductDto updateProduct(@PathVariable("id") Long id, @RequestBody GenericProductDto product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public GenericProductDto deleteProduct(@PathVariable("id") Long id) {
        return productService.deleteProduct(id);
    }

}
