package com.macademia.employeerecords.employeeapplication.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Random;

@Component
public class EmployeeService implements EmployeeRepositoryApi {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public ResponseEntity<Employee> createEmployee(Employee employee) {
        return new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.CREATED);
    }

    public ResponseEntity<Employee> getEmployee(Integer id) {
        return new ResponseEntity<>(employeeRepository.getById(id), HttpStatus.OK);
    }

    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<String> updateEmployee(Employee employee) {
        if(employeeRepository.existsById(employee.getId())) {
            employeeRepository.save(employee);
            return new ResponseEntity<>("Employee updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Unable to update employee", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteEmployee(Integer id) throws EmptyResultDataAccessException {
        try {
            employeeRepository.deleteById(id);
        } catch (EmptyResultDataAccessException exception) {
            return new ResponseEntity<>("Employee not found: ".concat(exception.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Employee deleted", HttpStatus.OK);
    }

    public ResponseEntity<List<Employee>> getEmployeesByStartDateAndSalary(Date startDate, BigDecimal salary) {
        return new ResponseEntity<>(employeeRepository.findEmployeesByStartDateAfterAndSalaryGreaterThan(startDate, salary), HttpStatus.OK);
    }

    public ResponseEntity<String> updateDepartmentOfficeLocation(String department, String officeLocation) {
        try{
            employeeRepository.updateOfficeLocationByDepartment(department, officeLocation);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error updating Office location: ".concat(ex.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Office location updated", HttpStatus.OK);
    }

    public ResponseEntity<Employee> getWinner() {
        return new ResponseEntity<>(employeeRepository.getMonthlyWinner(), HttpStatus.OK);
    }

    @Scheduled(cron = "0 0 9 1 * *")
    public void completeMonthlyDraw() {
        employeeRepository.resetWinner();
        List<Employee> employeeList = employeeRepository.findAll();
        employeeRepository.updateWinner(employeeList.get(new Random().nextInt(employeeList.size())).getId());
    }
}
