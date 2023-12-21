package com.example.crudemployer.web;

import com.example.crudemployer.entities.Employee;
import com.example.crudemployer.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeRestService {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getEmployes(){
        return employeeRepository.findAll();
    }

    @PostMapping("/createemployee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/updateemployee/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee newEmployee) {
       Employee e=employeeRepository.findById(id).get();
       e.setId(newEmployee.getId());
       e.setName(newEmployee.getName());
       e.setDateofrecruitment(newEmployee.getDateofrecruitment());
       return employeeRepository.save(e);
    }
    @DeleteMapping("/deleteemployee/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }

    @GetMapping("/auth")
    @ResponseBody
    public Authentication authentication(Authentication authentication){
        return authentication;
    }

}
