package com.cognizant.orm_learn;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.model.Department;
import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.model.Stock;
import com.cognizant.orm_learn.repository.StockRepository;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.DepartmentService;
import com.cognizant.orm_learn.service.EmployeeService;
import com.cognizant.orm_learn.service.SkillService;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;
    private static StockRepository stockRepository;
    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(OrmLearnApplication.class, args);

        countryService = context.getBean(CountryService.class);
        stockRepository = context.getBean(StockRepository.class);
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);
        
        //testDeleteCountry();
        //testGetFacebookStocks();
        //testGoogleStocks();
        //testHighestVolume();
        //testNetflixLowest();
        //testGetEmployee();
        //testAddEmployee();
        //testUpdateEmployee();
        //testGetEmployeeWithSkills();
        try {
            testFindCountry();
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found: {}", e.getMessage());
        }
           }

    private static void testGetAllCountries() {

        LOGGER.info("Start");

        List<Country> countries = countryService.getAllCountries();

        LOGGER.debug("Countries : {}", countries);

        LOGGER.info("End");
    }

    private static void testFindCountry() throws CountryNotFoundException {

    LOGGER.info("Start");

    Country country = countryService.findCountryByCode("IN");

    LOGGER.debug("Country : {}", country);

    LOGGER.info("End");
}
private static void testAddCountry() throws CountryNotFoundException {

    LOGGER.info("Start");

    Country country = new Country();

    country.setCode("JP");
    country.setName("Japan");

    countryService.addCountry(country);

    Country newCountry = countryService.findCountryByCode("JP");

    LOGGER.debug("Country : {}", newCountry);

    LOGGER.info("End");
}

private static void testUpdateCountry() throws CountryNotFoundException {

    LOGGER.info("Start");

    countryService.updateCountry("JP", "Japan Updated");

    Country country = countryService.findCountryByCode("JP");

    LOGGER.debug("Country : {}", country);

    LOGGER.info("End");
}
private static void testDeleteCountry() {

    LOGGER.info("Start");

    countryService.deleteCountry("JP");

    LOGGER.info("Country deleted successfully");

    LOGGER.info("End");
}


private static void testGetFacebookStocks() {

    List<Stock> stocks = stockRepository.findByCodeAndDateBetween(
            "FB",
            LocalDate.of(2019, 9, 1),
            LocalDate.of(2019, 9, 30));

    stocks.forEach(System.out::println);
}

private static void testGoogleStocks() {

    LOGGER.info("Google Stocks");

    List<Stock> stocks =
            stockRepository.findByCodeAndCloseGreaterThan(
                    "GOOGL",
                    1250);

    stocks.forEach(System.out::println);
}

private static void testHighestVolume() {

    LOGGER.info("Highest Volume");

    List<Stock> stocks =
            stockRepository.findTop3ByOrderByVolumeDesc();

    stocks.forEach(System.out::println);
}

private static void testNetflixLowest() {

    LOGGER.info("Netflix Lowest");

    List<Stock> stocks =
            stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");

    stocks.forEach(System.out::println);
}

private static void testGetEmployee() {

    LOGGER.info("Start");

    Employee employee = employeeService.get(1);

    LOGGER.debug("Employee : {}", employee);

    LOGGER.info("End");
}

private static void testAddEmployee() {

    LOGGER.info("Start");

    Department department = departmentService.get(2);

    Employee employee = new Employee();
    employee.setName("Pranavi");
    employee.setSalary(50000);
    employee.setPermanent(true);
    employee.setDateOfBirth(new java.util.Date());
    employee.setDepartment(department);

    employeeService.addEmployee(employee);

    LOGGER.info("Employee Added Successfully");

    LOGGER.info("End");
}
private static void testUpdateEmployee() {

    LOGGER.info("Start");

    Employee employee = employeeService.get(1);

    employee.setSalary(80000);

    employeeService.updateEmployee(employee);

    LOGGER.info("Employee Updated Successfully");

    LOGGER.info("End");
}

private static void testGetEmployeeWithSkills() {

    LOGGER.info("Start");

    Employee employee = employeeService.get(1);

    System.out.println("Employee : " + employee);
    System.out.println("Skills : ");

    employee.getSkills().forEach(System.out::println);

    LOGGER.info("End");
}



}