package com.springMVC.e_commerce_website.entity;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String categoryName;
    private Date addDate;
    private Date modDate;
    private long parentCatId;
}
