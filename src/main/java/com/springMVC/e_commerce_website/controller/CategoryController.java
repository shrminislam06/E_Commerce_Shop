package com.springMVC.e_commerce_website.controller;

import com.springMVC.e_commerce_website.entity.Categories;
import com.springMVC.e_commerce_website.model.AddCatModel;
import com.springMVC.e_commerce_website.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public List<Categories> categoriesList() {
        return categoryService.ListAll();
    }

    @GetMapping("/getbyName/{name}")
    public Categories getByName(@PathVariable String name){
        return categoryService.getByname(name);
    }

    @PostMapping("/category/add")
    public ResponseEntity<Boolean> addCategories(@RequestBody AddCatModel addCatModel) {
        return ResponseEntity.ok(categoryService.AddCategories(addCatModel));

    }

    @PutMapping("/category/update")
    public Categories updateCategory(@RequestBody AddCatModel addCatModel) {
        return categoryService.updateCategory(addCatModel);
    }

    @DeleteMapping("/category/delete/{id}")
    public boolean delete(@PathVariable("id") long id) {
        categoryService.delete(id);
        return true;
    }

}
