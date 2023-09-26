package com.springMVC.e_commerce_website.repository;

import com.springMVC.e_commerce_website.entity.Product;
import com.springMVC.e_commerce_website.projection.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(nativeQuery = true, value = "select p.id productId,\n" +
            "       p.name productName\n" +
            "       from pastry p\n" +
            "inner join categories c on p.categories_id = c.id\n" +
            "where c.id = :catId")
    List<ProductProjection> getAllProductByCatId(@Param("catId") Long catId);

    Set<Product> getAllByIdIn(Set<Long> productIds);

}
