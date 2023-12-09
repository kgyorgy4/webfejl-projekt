package com.example.springbackend.controller;

import com.example.springbackend.dto.EmployeeDTO;
import com.example.springbackend.dto.EmployeeSaveDTO;
import com.example.springbackend.dto.EmployeeUpdateDTO;
import com.example.springbackend.model.Employee;
import com.example.springbackend.repository.EmployeeRepo;
import com.example.springbackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/add")
    public String addEmployee(@RequestBody EmployeeSaveDTO employeeSaveDTO)
    {
        String id = employeeService.addEmployee(employeeSaveDTO);
        return id;
    }

    @GetMapping("/employees")
    public List<EmployeeDTO> getAllEmmployee()
    {
        List<EmployeeDTO>allEmployees = employeeService.getAllEmployee();
        return allEmployees;
    }

    @PutMapping("/update")
    public String updateEmployee(@RequestBody EmployeeUpdateDTO employeeUpdateDTO)
    {
        String id = employeeService.updateEmployee(employeeUpdateDTO);
        return id;
    }
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id )
    {
        boolean deleteEmployee = employeeService.deleteEmployee(id);
        return "deleted";
    }





}

