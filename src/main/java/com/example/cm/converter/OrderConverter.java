package com.example.cm.converter;

import com.example.cm.dto.Order;
import com.example.cm.dto.ProductInOrder;

import java.util.ArrayList;
import java.util.List;

public class OrderConverter {

    public static Order convertOrderEntityToOrderDTO(com.example.cm.entity.Order orderEntity){
        Order order = new Order();
        order.setId(orderEntity.getId());
        order.setOrderStatus(orderEntity.getOrderStatus());
        List<ProductInOrder> productInOrderList = new ArrayList<>();
        for (com.example.cm.entity.ProductInOrder productInOrder : orderEntity.getProductInOrder()) {
            productInOrderList.add(ProductInOrderConverter.convertProductInOrderEntityToProductInOrderDTO(productInOrder));
        }
        order.setProductInOrder(productInOrderList);
        return order;
    }

    public static com.example.cm.entity.Order convertOrderDTOToOrderEntity(Order order){
        com.example.cm.entity.Order orderEntity = new com.example.cm.entity.Order();
        orderEntity.setOrderStatus(order.getOrderStatus());
        List<com.example.cm.entity.ProductInOrder> productInOrderList = new ArrayList<>();
        for (ProductInOrder productInOrder : order.getProductInOrder()) {
            productInOrderList.add(ProductInOrderConverter.convertProductInOrderDTOToProductInOrderEntity(productInOrder));
        }
        orderEntity.setProductInOrder(productInOrderList);
        return orderEntity;
    }
}
