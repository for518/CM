package com.example.cm.dto;

import com.example.cm.entity.enums.ProductInOrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductInOrder {

    private Long id;

    private Integer amount;

    private Order order;

    private Product product;

    private ProductInOrderStatus productInOrderStatus;

}
