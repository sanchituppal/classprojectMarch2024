package com.example.projectservicesanchit.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Products {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private Category category;
}
