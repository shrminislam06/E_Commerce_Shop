package com.springMVC.e_commerce_website.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Entity
public class InvoiceItem {
    @EmbeddedId
    private InvoiceItemPk id;
    private int quantity;
    private double sellingPrice;
    private double totalAmount;
    private LocalDateTime addDate;
    private LocalDateTime modDate;


}
