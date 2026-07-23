package com.cognizant.orm_learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.orm_learn.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("""
            SELECT DISTINCT e
            FROM Employee e
            LEFT JOIN FETCH e.department
            LEFT JOIN FETCH e.skills
            WHERE e.permanent = true
            """)
    List<Employee> getAllPermanentEmployees();

    @Query("""
            SELECT DISTINCT e
            FROM Employee e
            LEFT JOIN FETCH e.department
            LEFT JOIN FETCH e.skills
            """)
    List<Employee> getAllEmployees();



@Query("""
SELECT e
FROM Employee e
WHERE e.name = :name
""")
List<Employee> findByEmployeeName(@Param("name") String name);
List<Employee> findByPermanent(boolean permanent);
}