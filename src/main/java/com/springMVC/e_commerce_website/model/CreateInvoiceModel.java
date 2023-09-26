package com.springMVC.e_commerce_website.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInvoiceModel {

    @NotNull(message = "Buyer Name can not be Empty")
    private String buyerName;
    private String contactNo;
    private double totalBill;
    @NotNull(message = "ProductList can not be Empty")
    List<ProductQtyModel> productQtyModels;
}
