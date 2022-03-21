package com.macademia.employeerecords.employeeapplication.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping
public class EmployeeRecordController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRecordController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employee/create")
    public ResponseEntity<Employee> createEmployee(Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
        return employeeService.getEmployee(id);
    }

    @PatchMapping("employee/update")
    public ResponseEntity<String> updateEmployee(Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employee/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam(value = "startDate", required = false) Date startDate, @RequestParam(value = "salary", required = false) BigDecimal salary) {
        return (null == startDate && null == salary ? employeeService.getAllEmployees() : employeeService.getEmployeesByStartDateAndSalary(startDate, salary));
    }

    @PutMapping("/department")
    public ResponseEntity<String> updateDepartmentOfficeLocation(String department, String officeLocation) {
        return employeeService.updateDepartmentOfficeLocation(department, officeLocation);
    }

    @GetMapping("/winner")
    public ResponseEntity<Employee> getWinner() {
         return employeeService.getWinner();
    }
}
