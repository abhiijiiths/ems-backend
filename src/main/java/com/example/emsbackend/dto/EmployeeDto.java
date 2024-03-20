package com.example.emsbackend.dto;


import com.example.emsbackend.entity.Project;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long Id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private Project project;
    private Long projectId;
}
