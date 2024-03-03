package com.example.projectservicesanchit.controllers;

import com.example.projectservicesanchit.dtos.CreateProductRequestDTO;
import com.example.projectservicesanchit.models.Products;
import com.example.projectservicesanchit.services.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;
    private RestTemplate restTemplate;
    public ProductController(ProductService productService, RestTemplate restTemplate) {
        this.productService = productService;
        this.restTemplate = restTemplate;
    }

    @PostMapping("/products")
    public Products createProduct(@RequestBody CreateProductRequestDTO request) {
        return productService.createProduct(
                request.getTitle(),
                request.getDescription(),
                request.getCategory(),
                request.getPrice(),
                request.getImage()
        );
    }

    //Getting list of all products
    @GetMapping("/products")
    public List<Products> getAllProducts() {
        return productService.getAllProducts();
    }

    //Getting list of all category
    @GetMapping("/products/categories")
    public List<String> getAllCategory(){
        return productService.getAllCategory();
    }
    //Update a product
    @PutMapping("products/{id}")
    public Products updateProduct(@PathVariable("id") Long id, @RequestBody Products product){
        return productService.updateProduct(id, product);
    }

    //Delete a product
    @DeleteMapping("products/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }

    //Get products in a specific category
    @GetMapping("products/category/{category}")
    List<Products> getBySpecificCategory(@PathVariable("category") String category){
        return productService.getBySpecificCategory(category);
    }

    @GetMapping("/products/{id}")
    public Products getProductDetails(@PathVariable("id") Long productId) {
        return productService.getSingleProduct(productId);
    }
}
