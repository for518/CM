package com.example.cm.controller;

import com.example.cm.dto.ProductInOrder;
import com.example.cm.dtoooo.ProductInOrderDTO;
import com.example.cm.entity.Order;
import com.example.cm.entity.Product;
import com.example.cm.entity.Table;
import com.example.cm.service.ManagerService;
import com.example.cm.service.WaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private WaiterService waiterService;

    @Autowired
    private ManagerService managerService;

    @PostMapping("/table")
    public void createTable(@RequestBody Table table){
        managerService.createTable(table);
    }

    @PostMapping("/products")
    public void createProducts(@RequestBody List<Product> products){
        managerService.createProducts(products);
    }

    @PostMapping("/assign_table/{tableId}/to_waiter/{waiterId}")
    public void assignTablesToWaiters(@PathVariable Long tableId, @PathVariable Long waiterId){
        managerService.assignTableToWaiters(tableId, waiterId);
    }

    @ResponseBody
    @GetMapping("/waiter/{waiterId}/tables")
    public List<com.example.cm.dto.Table> getAssignedTables(@PathVariable Long waiterId){

        return waiterService.getAssignedTables(waiterId);
    }

    @PostMapping("/table/{tableId}/order")
    public void createOrder(@PathVariable Long tableId, @RequestBody Order order){
        waiterService.createOrder(tableId, order);
    }

    @PutMapping("/order/{orderId}")
    public void createOrder(@PathVariable Long orderId, @RequestBody com.example.cm.dto.Order order){
        waiterService.updateOrder(orderId, order);
    }

    @PostMapping("/product_in_order")
    public void createProductInOrder(@RequestBody ProductInOrderDTO productInOrderDTO){
        waiterService.createProductInOrder(productInOrderDTO);
    }

    @PutMapping("/product_in_order/{productInOrderId}")
    public void updateProductInOrder(@PathVariable Long productInOrderId, @RequestBody com.example.cm.dto.ProductInOrder productInOrder){
        waiterService.updateProductInOrder(productInOrderId, productInOrder);
    }
}
