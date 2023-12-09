package com.example.springbackend.service;

import com.example.springbackend.dto.EmployeeDTO;
import com.example.springbackend.dto.EmployeeSaveDTO;
import com.example.springbackend.dto.EmployeeUpdateDTO;
import com.example.springbackend.model.Employee;

import java.util.List;

public interface EmployeeService {

    String addEmployee(EmployeeSaveDTO employeeSaveDTO);


    List<EmployeeDTO> getAllEmployee();

    String updateEmployee(EmployeeUpdateDTO employeeUpdateDTO);

    boolean deleteEmployee(long id);
}
