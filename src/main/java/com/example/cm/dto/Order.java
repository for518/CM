package com.example.cm.dto;

import com.example.cm.entity.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Long id;
    private OrderStatus orderStatus;
    private List<ProductInOrder> productInOrder;
    private Table table;
}
