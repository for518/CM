package com.example.cm.converter;


import com.example.cm.dto.Product;

public class ProductConverter {
    public static Product convertProductEntityToProductDTO(com.example.cm.entity.Product productEntity) {
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setCurrency(productEntity.getCurrency());
        product.setPrice(productEntity.getPrice());
        product.setName(productEntity.getName());

        return product;
    }

    public static com.example.cm.entity.Product convertProductDTOToProductEntity(Product product) {
        com.example.cm.entity.Product productEntity = new com.example.cm.entity.Product();
        productEntity.setCurrency(product.getCurrency());
        productEntity.setPrice(product.getPrice());
        productEntity.setName(product.getName());

        return productEntity;
    }
}
