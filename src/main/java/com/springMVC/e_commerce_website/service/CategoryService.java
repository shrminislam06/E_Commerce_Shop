package com.springMVC.e_commerce_website.service;

import com.springMVC.e_commerce_website.entity.Categories;
import com.springMVC.e_commerce_website.model.AddCatModel;

import java.util.List;

public interface CategoryService {
    List<Categories> ListAll();

    Boolean AddCategories(AddCatModel addCatModel);

    Categories updateCategory(AddCatModel addCatModel);

    void delete(long id);

    Categories getByname(String name);
}
