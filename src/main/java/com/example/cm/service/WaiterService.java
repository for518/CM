package com.example.cm.service;
import com.example.cm.converter.OrderConverter;
import com.example.cm.converter.ProductConverter;
import com.example.cm.converter.ProductInOrderConverter;
import com.example.cm.converter.TableConverter;
import com.example.cm.converter.UserConverter;
import com.example.cm.dtoooo.ProductInOrderDTO;
import com.example.cm.entity.enums.OrderStatus;
import com.example.cm.entity.Order;
import com.example.cm.entity.Product;
import com.example.cm.entity.ProductInOrder;
import com.example.cm.entity.enums.ProductInOrderStatus;
import com.example.cm.entity.Table;
import com.example.cm.repo.OrderRepository;
import com.example.cm.repo.ProductInOrderRepository;
import com.example.cm.repo.ProductRepository;
import com.example.cm.repo.TableRepository;
import com.example.cm.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class WaiterService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductInOrderRepository productInOrderRepository;

    public List<com.example.cm.dto.Table> getAssignedTables(Long userId) {

        return UserConverter.convertUserEntityToUserDTO(userRepository.getReferenceById(userId)).getAssignedTables();
    }


    @Transactional
    public void createOrder(Long tableId, Order order) {
        Table table = tableRepository.getReferenceById(tableId);
        if (existOpenOrder(table)) {
            throw new RuntimeException("The table has order with open status");
        }
        order.setTable(table);
        order.setOrderStatus(OrderStatus.OPEN);
        orderRepository.save(order);
    }

    private boolean existOpenOrder(Table table) {
        for (Order order : table.getOrders()) {
            if (order.getOrderStatus().equals(OrderStatus.OPEN)) {
                return true;
            }
        }
        return false;
    }

    public void updateOrder(Long orderId, com.example.cm.dto.Order orderDTO) {
        Order order = orderRepository.getReferenceById(orderId);
        if(orderDTO.getOrderStatus() != null){
            order.setOrderStatus(orderDTO.getOrderStatus());
        }
        if(orderDTO.getTable() != null){
            order.setTable(TableConverter.convertTableDTOToTableEntity(orderDTO.getTable()));
        }
        orderRepository.save(order);
    }

    public void createProductInOrder(ProductInOrderDTO productInOrderDTO) {
        Order order = orderRepository.getReferenceById(productInOrderDTO.getOrderId());
        Product product = productRepository.getReferenceById(productInOrderDTO.getProductId());
        ProductInOrder productInOrder = new ProductInOrder();
        productInOrder.setProduct(product);
        productInOrder.setProductInOrderStatus(ProductInOrderStatus.ACTIVE);
        productInOrder.setAmount(productInOrderDTO.getAmount());
        productInOrder.setOrder(order);
        productInOrderRepository.save(productInOrder);
    }


    public void updateProductInOrder(Long productInOrderId, com.example.cm.dto.ProductInOrder productInOrderDTO) {
        ProductInOrder productInOrder = productInOrderRepository.getReferenceById(productInOrderId);
        if(productInOrderDTO.getAmount() != null){
            productInOrder.setAmount(productInOrderDTO.getAmount());
        }
        if(productInOrderDTO.getProductInOrderStatus() != null){
            productInOrder.setProductInOrderStatus(productInOrderDTO.getProductInOrderStatus());
        }
        if(productInOrderDTO.getProduct() != null){
            productInOrder.setProduct(ProductConverter.convertProductDTOToProductEntity(productInOrderDTO.getProduct()));
        }
//        if(productInOrderDTO.getOrder() != null){
//            productInOrder.setOrder(OrderConverter.convertOrderDTOToOrderEntity(productInOrderDTO.getOrder()));
//        }
        productInOrderRepository.save(productInOrder);
    }


}