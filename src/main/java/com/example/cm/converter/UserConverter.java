package com.example.cm.converter;

import com.example.cm.dto.Table;
import com.example.cm.dto.User;

import java.util.ArrayList;
import java.util.List;

public class UserConverter {
    public static User convertUserEntityToUserDTO(com.example.cm.entity.User userEntity){
        User user = new User();
        user.setId(userEntity.getId());
        user.setUserType(userEntity.getUserType());
        user.setBirthDate(userEntity.getBirthDate());
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setGender(userEntity.getGender());
        List<Table> tableList = new ArrayList<>();
        for (com.example.cm.entity.Table table : userEntity.getAssignedTables()) {
            tableList.add(TableConverter.convertTableEntityToTableDTO(table));
        }

        user.setAssignedTables(tableList);
        return user;
    }

    public static com.example.cm.entity.User convertUserDTOToUserEntity(User user){
        com.example.cm.entity.User userEntity = new com.example.cm.entity.User();
        userEntity.setUserType(user.getUserType());
        userEntity.setBirthDate(user.getBirthDate());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setGender(user.getGender());
        List<com.example.cm.entity.Table> tableList = new ArrayList<>();
        for (Table table : user.getAssignedTables()) {
            tableList.add(TableConverter.convertTableDTOToTableEntity(table));
        }

        userEntity.setAssignedTables(tableList);
        return userEntity;
    }


}
