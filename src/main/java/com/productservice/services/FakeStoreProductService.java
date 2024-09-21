package com.productservice.services;

import com.productservice.dtos.FakeStoreProductDto;
import com.productservice.dtos.GenericProductDto;
import com.productservice.thirdPartyClients.fakeStoreClient.FakeStoreClientAdapter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private FakeStoreClientAdapter fakeStoreClientAdapter;

    public FakeStoreProductService(FakeStoreClientAdapter fakeStoreClientAdapter) {
        this.fakeStoreClientAdapter = fakeStoreClientAdapter;
    }


    @Override
    public GenericProductDto getProductById(Long id) {
        return convertToGenericProductDto(fakeStoreClientAdapter.getProductById(id));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        FakeStoreProductDto[] products = fakeStoreClientAdapter.getAllProducts();
        List<GenericProductDto> response = new ArrayList<>();
        for (FakeStoreProductDto product : products) {
            response.add(convertToGenericProductDto(product));
        }
        return response;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return convertToGenericProductDto(fakeStoreClientAdapter.createProduct(product));
    }

    @Override
    public GenericProductDto updateProduct(Long id, GenericProductDto product) {
        return convertToGenericProductDto(fakeStoreClientAdapter.updateProduct(id, product));
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        return convertToGenericProductDto(fakeStoreClientAdapter.deleteProduct(id));
    }

    private static GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());

        return genericProductDto;
    }
}
