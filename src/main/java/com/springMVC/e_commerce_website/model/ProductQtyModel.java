package com.springMVC.e_commerce_website.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductQtyModel {
    @NotNull(message = "productId can not be Empty")
    private Long productId;
    @NotNull(message = "productQty can not be Empty")
    private Integer productQty;
}
