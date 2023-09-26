
package com.springMVC.e_commerce_website.controller;

import com.springMVC.e_commerce_website.entity.Product;

import com.springMVC.e_commerce_website.model.ProductModel;
import com.springMVC.e_commerce_website.projection.ProductProjection;
import com.springMVC.e_commerce_website.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/product")
        public Iterable<Product>pastries(){
        return productService.AllProduct();

    }

    @PostMapping("/addProduct")
    public ResponseEntity<Product>AddCategory(@RequestBody ProductModel productModel){
        return ResponseEntity.ok(productService.AddCategory(productModel));
    }

    @PutMapping("/update")
    public Product UpdateCategories(@RequestBody ProductModel productModel){
      return productService.update(productModel);

    }
    @DeleteMapping("/product/delete/{id}")
    public void deleteProduct(@PathVariable("id") long id){
        productService.delete(id);

    }

    @GetMapping("/getAllProductListByCatId")
    public ResponseEntity<List<ProductProjection>> getAllProductListByCatId(@RequestParam long catId) {
        return ResponseEntity.ok(productService.getAllProductListByCatId(catId));
    }
}
