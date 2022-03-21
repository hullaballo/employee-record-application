package com.macademia.employeerecords.employeeapplication.employee;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeService(employeeRepository);
    }

    @Test
    void createEmployee() {

        verify(employeeService.createEmployee(Employee.builder().build()));
    }

    @Test
    void getEmployee() {
    }

    @Test
    void getAllEmployees() {
    }

    @Test
    void updateEmployee() {
    }

    @Test
    void deleteEmployee() {
    }

    @Test
    void getEmployeesByStartDateAndSalary() {
    }

    @Test
    void updateDepartmentOfficeLocation() {
    }

    @Test
    void getMonthlyWinner() {
    }

    @Test
    void completeMonthlyDraw() {
    }
}