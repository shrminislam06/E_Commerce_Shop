package com.springMVC.e_commerce_website.repository;

import com.springMVC.e_commerce_website.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface Categoryrepository extends JpaRepository<Categories,Long> {

    // List<Categories> findAllCategoryByIdIn(Set<Long> categoryId);
    Categories findByCategoryName(String name);
     List<Categories> findAllByIdIn(Set<Long> categoryId);
}
