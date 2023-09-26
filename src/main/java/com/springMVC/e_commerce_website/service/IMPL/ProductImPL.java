package com.springMVC.e_commerce_website.service.IMPL;

import com.springMVC.e_commerce_website.entity.Categories;
import com.springMVC.e_commerce_website.entity.Product;

import com.springMVC.e_commerce_website.model.ProductModel;
import com.springMVC.e_commerce_website.projection.ProductProjection;
import com.springMVC.e_commerce_website.repository.Categoryrepository;

import com.springMVC.e_commerce_website.repository.ProductRepository;
import com.springMVC.e_commerce_website.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductImPL implements ProductService {
    private ProductRepository productRepository;
    private Categoryrepository categoryrepository;

    public ProductImPL(ProductRepository productRepository, Categoryrepository categoryrepository) {
        this.productRepository = productRepository;
        this.categoryrepository = categoryrepository;
    }


    @Override
    public Iterable<Product> AllProduct() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductProjection> getAllProductListByCatId(long catId) {
        return productRepository.getAllProductByCatId(catId);
    }

    @Override
    public Product AddCategory(ProductModel productModel) {
        Categories categories = categoryrepository.findById(productModel.getCategoriesIds())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "cat id not found.!" + productModel.getCategoriesIds()));
        Product product = new Product();
        product.setName(productModel.getName());
        product.setSellingPrice(productModel.getSellingPrice());
        product.setCategories(categories);
        productRepository.save(product);
        return product;

    }

    @Override
    public void delete(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product update(ProductModel productModel) {
        Categories categories = categoryrepository.findById(productModel.getCategoriesIds())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "cat id not found.!" + productModel.getCategoriesIds()));
        Product product = productRepository.findById(productModel.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "id not found" + productModel.getId()));
        product.setName(productModel.getName());
        product.setPWeight(productModel.getPWeight());
        product.setSellingPrice(productModel.getSellingPrice());
        product.setCategories(categories);
        productRepository.save(product);
        return product;
    }


}

