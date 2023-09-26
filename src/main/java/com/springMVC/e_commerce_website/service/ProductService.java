package com.springMVC.e_commerce_website.service;

import com.springMVC.e_commerce_website.entity.Product;

import com.springMVC.e_commerce_website.model.ProductModel;
import com.springMVC.e_commerce_website.projection.ProductProjection;

import java.util.List;

public interface ProductService {


    Product AddCategory(ProductModel productModel);

    void delete(long id);

    Product update(ProductModel productModel);

    Iterable<Product> AllProduct();

    List<ProductProjection> getAllProductListByCatId(long catId);
}
