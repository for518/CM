package com.example.cm.converter;

import com.example.cm.dto.Order;
import com.example.cm.dto.Table;

import java.util.ArrayList;
import java.util.List;

public class TableConverter {

    public static Table convertTableEntityToTableDTO(com.example.cm.entity.Table tableEntity){
        Table table = new Table();
        table.setCapacity(tableEntity.getCapacity());
        table.setId(tableEntity.getId());
        table.setUserId(tableEntity.getUser().getId());
        List<Order> orders = new ArrayList<>();
        for (com.example.cm.entity.Order order : tableEntity.getOrders()) {
            orders.add(OrderConverter.convertOrderEntityToOrderDTO(order));
        }
        table.setOrders(orders);

        return table;
    }

    public static com.example.cm.entity.Table convertTableDTOToTableEntity(Table table){
        com.example.cm.entity.Table tableEntity = new com.example.cm.entity.Table();
        tableEntity.setCapacity(table.getCapacity());
        List<com.example.cm.entity.Order> orders = new ArrayList<>();
        for (Order order : table.getOrders()) {
            orders.add(OrderConverter.convertOrderDTOToOrderEntity(order));
        }
        tableEntity.setOrders(orders);

        return tableEntity;
    }
}
