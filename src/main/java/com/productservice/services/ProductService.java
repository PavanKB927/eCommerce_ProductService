package com.productservice.services;

import com.productservice.dtos.GenericProductDto;

import java.util.List;

public interface ProductService {
    GenericProductDto getProductById(Long id);
    List<GenericProductDto> getAllProducts();
    GenericProductDto createProduct(GenericProductDto product);
    GenericProductDto updateProduct(Long id, GenericProductDto product);
    GenericProductDto deleteProduct(Long id);
}
