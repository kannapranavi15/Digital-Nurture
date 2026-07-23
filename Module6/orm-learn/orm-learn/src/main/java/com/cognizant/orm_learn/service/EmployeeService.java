package com.cognizant.orm_learn.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository employeeRepository;
     
    @Transactional
public Employee get(int id) {

    LOGGER.info("Start");

    Employee employee = employeeRepository.findById(id).get();

    // Initialize the lazy collection
    employee.getSkills().size();

    LOGGER.info("End");

    return employee;
}
    

    @Transactional
    public void save(Employee employee) {
        LOGGER.info("Start");
        employeeRepository.save(employee);
        LOGGER.info("End");
    }
    @Transactional
    public void addEmployee(Employee employee) {
        LOGGER.info("Start");
        employeeRepository.save(employee);
        LOGGER.info("End");
    }

    @Transactional
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Transactional
public Employee getEmployee(int id) {
    LOGGER.info("Start");
    Employee employee = employeeRepository.findById(id).get();
    LOGGER.info("End");
    return employee;
}
}