package com.example.projectservicesanchit.services;

import com.example.projectservicesanchit.dtos.FakeStoreProductDTO;
import com.example.projectservicesanchit.models.Products;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    public RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Products getSingleProduct(Long productId) {
        FakeStoreProductDTO fakeStoreProduct = restTemplate.getForObject(
                "https://fakestoreapi.com/products/"+productId,
                FakeStoreProductDTO.class
        );
        return fakeStoreProduct.toProduct();
    }

    @Override
    public List<Products> getAllProducts() {
        FakeStoreProductDTO[] allfakeStoreProductDTO = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDTO[].class);
        List<Products> answerProducts = new ArrayList<>();
        for (FakeStoreProductDTO dto :allfakeStoreProductDTO ){
            answerProducts.add(dto.toProduct());
        }
        return answerProducts;
    }

    @Override
    public List<String> getAllCategory() {
        List<String> ansGetAllCategory =  restTemplate.getForObject(
                "https://fakestoreapi.com/products/categories",
                List.class
        );
        return ansGetAllCategory;
    }

    @Override
    public Products createProduct(
            String title,
            String description,
            String category,
            Double price,
            String image) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(title);
        fakeStoreProductDTO.setCategory(category);
        fakeStoreProductDTO.setPrice(price);
        fakeStoreProductDTO.setImage(image);
        fakeStoreProductDTO.setDescription(description);

        FakeStoreProductDTO response = restTemplate.postForObject(
                "https://fakestoreapi.com/products", // url
                fakeStoreProductDTO, // request body
                FakeStoreProductDTO.class // data type of response
        );

        if (response == null) return new Products();

        return response.toProduct();
    }
    @Override
    public Products updateProduct(Long id, Products product) {
        FakeStoreProductDTO responseUpdate = new FakeStoreProductDTO();
        responseUpdate.setId(product.getId());
        responseUpdate.setTitle(product.getTitle());
        responseUpdate.setDescription(product.getDescription());
        responseUpdate.setImage(product.getImageUrl());
        responseUpdate.setPrice(product.getPrice());
        responseUpdate.setCategory(product.getCategory().getTitle()
        );

        restTemplate.put(
                "https://fakestoreapi.com/products/" + id,
                responseUpdate);

        return  responseUpdate.toProduct();
    }

    @Override
    public void deleteProduct(Long id) {
        restTemplate.delete("https://fakestoreapi.com/products/"+id);
    }

    @Override
    public List<Products> getBySpecificCategory(String category) {
        FakeStoreProductDTO[] fakeStoreProductDTO =
                restTemplate.getForObject("https://fakestoreapi.com/products/category/"+category,
                        FakeStoreProductDTO[].class);
        List<Products> answer = new ArrayList<>();
        for(FakeStoreProductDTO dto: fakeStoreProductDTO){
            answer.add(dto.toProduct());
        }
        return answer;
    }
}