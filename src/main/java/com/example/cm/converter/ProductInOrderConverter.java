package com.example.cm.converter;

import com.example.cm.dto.ProductInOrder;

public class ProductInOrderConverter {
    public static ProductInOrder convertProductInOrderEntityToProductInOrderDTO(com.example.cm.entity.ProductInOrder productInOrderEntity){
        ProductInOrder productInOrder = new ProductInOrder();
        productInOrder.setId(productInOrderEntity.getId());
        productInOrder.setAmount(productInOrderEntity.getAmount());
        productInOrder.setProduct(ProductConverter.convertProductEntityToProductDTO(productInOrderEntity.getProduct()));
        productInOrder.setProductInOrderStatus(productInOrderEntity.getProductInOrderStatus());

        return productInOrder;
    }

    public static com.example.cm.entity.ProductInOrder convertProductInOrderDTOToProductInOrderEntity(ProductInOrder productInOrder) {
        com.example.cm.entity.ProductInOrder productInOrderEntity = new com.example.cm.entity.ProductInOrder();
        productInOrderEntity.setAmount(productInOrder.getAmount());
        productInOrderEntity.setProduct(ProductConverter.convertProductDTOToProductEntity(productInOrder.getProduct()));
        productInOrderEntity.setProductInOrderStatus(productInOrder.getProductInOrderStatus());

        return productInOrderEntity;
    }
}
