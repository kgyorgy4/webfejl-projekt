package com.example.springbackend.service;

import com.example.springbackend.dto.EmployeeDTO;
import com.example.springbackend.dto.EmployeeSaveDTO;
import com.example.springbackend.dto.EmployeeUpdateDTO;
import com.example.springbackend.model.Employee;
import com.example.springbackend.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImp  implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public String addEmployee(EmployeeSaveDTO employeeSaveDTO) {
        Employee employee = new Employee(

            employeeSaveDTO.getfirst_name(), employeeSaveDTO.getlast_name(),employeeSaveDTO.getEmail()

        );
        employeeRepo.save(employee);
        return employee.getfirst_name();

    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> getEmployees = employeeRepo.findAll();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for(Employee a:getEmployees)
        {
            EmployeeDTO employeeDTO = new EmployeeDTO(
                    a.getId(),
                    a.getfirst_name(),
                    a.getlast_name(),
                    a.getEmail()
            );
            employeeDTOList.add(employeeDTO);
        }
    return employeeDTOList;
    }

    @Override
    public String updateEmployee(EmployeeUpdateDTO employeeUpdateDTO) {
        if (employeeRepo.existsById(employeeUpdateDTO.getId()))
        {
            Employee employee = employeeRepo.getById(employeeUpdateDTO.getId());
            employee.setfirst_name(employeeUpdateDTO.getfirst_name());
            employee.setlast_name(employeeUpdateDTO.getlast_name());
            employee.setEmail(employeeUpdateDTO.getEmail());
            employeeRepo.save(employee);
        }
        return null;
    }

    @Override
    public boolean deleteEmployee(long id) {
        if (employeeRepo.existsById(id))
        {
            employeeRepo.deleteById(id);

        }
        return true;
    }
}
