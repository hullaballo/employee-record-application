package com.macademia.employeerecords.employeeapplication.employee;

import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public interface EmployeeRepositoryApi {

    ResponseEntity<List<Employee>> getAllEmployees();

    ResponseEntity<Employee> getEmployee(Integer id);

    ResponseEntity<String> updateEmployee(Employee employee);

    ResponseEntity<List<Employee>> getEmployeesByStartDateAndSalary(Date startDate, BigDecimal salary);

    ResponseEntity<String> updateDepartmentOfficeLocation(String department, String officeLocation);

    ResponseEntity<Employee> getWinner();
}
