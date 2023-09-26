package com.springMVC.e_commerce_website.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCatModel {
    private long id;
    private String categoryName;
    private Date addDate;
    private Date modDate;
    private Long parentCatId;
}
