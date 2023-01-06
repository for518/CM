package com.example.cm.dtoooo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductInOrderDTO {
    private Long orderId;
    private Long productId;
    private int amount;
}
