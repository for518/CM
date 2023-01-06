package com.example.cm.dto;

import com.example.cm.entity.enums.Gender;
import com.example.cm.entity.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String firstName;
    private String lastName;
    private Gender gender;
    private OffsetDateTime birthDate;
    private UserType userType;


    private Long id;

    private List<Table> assignedTables;

}
