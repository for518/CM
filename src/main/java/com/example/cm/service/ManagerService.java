package com.example.cm.service;


import com.example.cm.entity.Product;
import com.example.cm.entity.Table;
import com.example.cm.repo.ProductRepository;
import com.example.cm.repo.TableRepository;
import com.example.cm.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {

    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public void createTable(Table table){
        tableRepository.save(table);
    }

    public void createProducts(List<Product> products){
        for (Product product : products) {
            productRepository.save(product);
        }
    }

    public void assignTableToWaiters(long tableId, long userId){
//        User user = userRepository.getReferenceById(userId);
//        user.getAssignedTables().add(tableRepository.getReferenceById(tableId));
//        userRepository.save(user);
        Table table = tableRepository.getReferenceById(tableId);
        table.setUser(userRepository.getReferenceById(userId));
        tableRepository.save(table);
    }

}
