package com.example.emsbackend.repository;

import com.example.emsbackend.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    void deleteByOrgId(Long id);
    List<Department> findByOrgId(Long id);
}
