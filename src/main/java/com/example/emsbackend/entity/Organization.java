package com.example.emsbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "org_id")
    private Long orgId;
    @Column(name = "org_name", nullable = false)
    private String orgName;
    @Column(name = "org_dec")
    private String orgDec;

    @OneToMany(mappedBy = "organization",cascade = CascadeType.REMOVE)
    private Set<Department> departments;
}
