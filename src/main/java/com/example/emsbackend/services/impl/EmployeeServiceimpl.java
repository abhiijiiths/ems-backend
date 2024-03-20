package com.example.emsbackend.services.impl;

import com.example.emsbackend.dto.EmployeeDto;
import com.example.emsbackend.entity.Employee;
import com.example.emsbackend.exception.ResourseNotFoundException;
import com.example.emsbackend.mapper.EmployeeMapper;
import com.example.emsbackend.repository.EmployeeRepository;
import com.example.emsbackend.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceimpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);

    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourseNotFoundException("Employee Not Exist with Given id "+id));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee(){
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee)).
                collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployeeByid(Long id, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(id).
                orElseThrow(()->new ResourseNotFoundException("Employee Not Fount of id "+id));

        if(updatedEmployee.getFirstName()!=null)employee.setFirstName(updatedEmployee.getFirstName());
        if(updatedEmployee.getLastName()!=null)employee.setLastName(updatedEmployee.getLastName());
        if(updatedEmployee.getEmail()!=null)employee.setEmail(updatedEmployee.getEmail());
        if(updatedEmployee.getAge()!=null)employee.setAge(updatedEmployee.getAge());
        if(updatedEmployee.getProjectId()!=null)employee.setProjectId(updatedEmployee.getProjectId());

        Employee updatedEmployyeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployyeObj);
    }

    @Override
    public void deleteEmpoloyeeById(Long id) {
        Employee employee = employeeRepository.findById(id).
                orElseThrow(()->new ResourseNotFoundException("Employee Not Fount of id "+id));
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDto getEmployeeByName(String name) {
        Employee employee = employeeRepository.findByFirstName(name);
        if (employee == null){
            throw new ResourseNotFoundException("Employee Not Fount ");
        }
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public EmployeeDto getEmployeeByEmail(String email) {
        Employee employee = employeeRepository.findByEmail(email);
        if (employee == null){
            throw new ResourseNotFoundException("Employee Not Found");
        }
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getEmployeeUnderAge(Integer age) {
        List<Employee> employees = employeeRepository.findByAgeLessThan(age);
        return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee)).
                collect(Collectors.toList());
    }
}
