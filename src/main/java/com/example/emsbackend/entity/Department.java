package com.example.emsbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.SecureRandom;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private Long depttId;
    @Column(name = "dept_name" ,nullable = false)
    private String deptName;
    @Column(name = "dept_dec")
    private String deptDec;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "org_id",insertable = false,updatable = false)
    private Organization organization;

    @Column(name = "org_id",nullable = false)
    private Long orgId;
}
