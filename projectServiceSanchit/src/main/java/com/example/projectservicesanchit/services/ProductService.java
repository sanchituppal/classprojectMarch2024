package com.example.projectservicesanchit.services;

import com.example.projectservicesanchit.models.Products;

import java.util.List;

public interface ProductService {
    Products getSingleProduct(Long productId);

    List<Products> getAllProducts();

    List<String> getAllCategory();

        Products createProduct(String title,
                           String description,
                           String category,
                           Double price,
                           String image);
    Products updateProduct(Long id, Products product);
    void deleteProduct(Long id);
    List<Products> getBySpecificCategory(String category);
}
