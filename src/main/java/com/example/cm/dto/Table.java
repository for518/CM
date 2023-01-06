package com.example.cm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@javax.persistence.Table(name = "Tables")
public class Table {


    private Long id;
    private int capacity;

    private List<Order> orders;

//    private User waiter;

    private Long userId;

}
