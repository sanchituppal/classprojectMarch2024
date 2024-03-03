package com.example.projectservicesanchit.dtos;

import com.example.projectservicesanchit.models.Category;
import com.example.projectservicesanchit.models.Products;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private String image;
    private String description;
    private String category;
    private Double price;

    public Products toProduct() {
        Products product = new Products();
        product.setId(id);
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);

        Category productCategory = new Category();
        productCategory.setTitle(category);
        product.setCategory(productCategory);
        return product;
    }
}
