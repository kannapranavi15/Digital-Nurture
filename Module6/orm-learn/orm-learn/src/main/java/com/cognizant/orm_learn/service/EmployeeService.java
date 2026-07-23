
package com.cognizant.orm_learn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

        // Initialize lazy collection
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

        LOGGER.info("Start");

        employeeRepository.save(employee);

        LOGGER.info("End");
    }

    @Transactional
    public Employee getEmployee(int id) {

        LOGGER.info("Start");

        Employee employee = employeeRepository.findById(id).get();

        LOGGER.info("End");

        return employee;
    }

    @Transactional
    public List<Employee> getAllPermanentEmployees() {

        LOGGER.info("Start");

        List<Employee> employees = employeeRepository.getAllPermanentEmployees();

        LOGGER.info("End");

        return employees;
    }

    @Transactional
    public List<Employee> getAllEmployees() {

        LOGGER.info("Start");

        List<Employee> employees = employeeRepository.getAllEmployees();

        LOGGER.info("End");

        return employees;
    }

    @Transactional
public void deleteEmployee(int id) {

    LOGGER.info("Start");

    employeeRepository.deleteById(id);

    LOGGER.info("End");
}

@Transactional(readOnly = true)
public List<Employee> findByEmployeeName(String name) {

    LOGGER.info("Start");

    List<Employee> employees =
            employeeRepository.findByEmployeeName(name);

    LOGGER.info("End");

    return employees;
}

@Transactional(readOnly = true)
public List<Employee> getPermanentEmployees() {

    LOGGER.info("Start");

    List<Employee> employees =
            employeeRepository.findByPermanent(true);

    LOGGER.info("End");

    return employees;
}
@Transactional
public List<Employee> getEmployeesSorted() {
    return employeeRepository.findAll(Sort.by("salary").descending());
}

@Transactional
public Page<Employee> getEmployees(int pageNo) {
    Pageable pageable = PageRequest.of(pageNo, 2);
    return employeeRepository.findAll(pageable);
}

@Transactional
public long getEmployeeCount() {
    return employeeRepository.count();
}

@Transactional
public boolean employeeExists(int id) {
    return employeeRepository.existsById(id);
}


}