package com.example.crudemployer;

import com.example.crudemployer.entities.Employee;
import com.example.crudemployer.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class CrudEmployerApplication implements CommandLineRunner {

    @Autowired
    EmployeeRepository employeeRepository;


    public static void main(String[] args) {
        SpringApplication.run(CrudEmployerApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
    employeeRepository.save(new Employee(null,"yasmine",new Date()));
    employeeRepository.save(new Employee(null,"yousra",new Date()));
    employeeRepository.save(new Employee(null, "sofia", new Date()));
    }
}
