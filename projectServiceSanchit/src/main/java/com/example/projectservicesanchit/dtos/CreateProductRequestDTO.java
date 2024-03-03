package com.example.projectservicesanchit.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDTO {
    private String title;
    private String image;
    private String description;
    private String category;
    private Double price;
}
