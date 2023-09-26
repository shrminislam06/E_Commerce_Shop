package com.springMVC.e_commerce_website.service.IMPL;

import com.springMVC.e_commerce_website.entity.Categories;
import com.springMVC.e_commerce_website.model.AddCatModel;
import com.springMVC.e_commerce_website.repository.Categoryrepository;
import com.springMVC.e_commerce_website.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryIMPL implements CategoryService {

    private Categoryrepository categoryrepository;

    public CategoryIMPL(Categoryrepository categoryrepository) {
        this.categoryrepository = categoryrepository;
    }

    @Override
    public List<Categories> ListAll() {
        return categoryrepository.findAll();
    }

    @Override
    public Boolean AddCategories(AddCatModel addCatModel) {
        Categories categories = new Categories();
        categories.setCategoryName(addCatModel.getCategoryName());
        categories.setAddDate(Date.valueOf(LocalDate.now()));
        categories.setModDate(Date.valueOf(LocalDate.now()));
        categories.setParentCatId(addCatModel.getParentCatId() == null ? 0 : addCatModel.getParentCatId());
        categoryrepository.save(categories);
        return true;
    }


    @Override
    public Categories updateCategory(AddCatModel addCatModel) {
        Categories categories= categoryrepository.findById(addCatModel.getId())
                .orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"cat id not found"+addCatModel.getId()));
        categories.setCategoryName(addCatModel.getCategoryName());
        categories.setModDate(Date.valueOf(LocalDate.now()));
        categoryrepository.save(categories);
        return categories;
    }

    @Override
    public void delete(long id) {
        categoryrepository.deleteById(id);
    }

    @Override
    public Categories getByname(String name) {
        return categoryrepository.findByCategoryName(name);
    }
}
