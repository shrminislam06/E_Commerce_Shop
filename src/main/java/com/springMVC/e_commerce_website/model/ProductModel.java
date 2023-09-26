package com.springMVC.e_commerce_website.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductModel {
    private long id;
    private String name;
    private long parentCatId;
    private double sellingPrice;
    private String pWeight;
   private Long categoriesIds;
}
