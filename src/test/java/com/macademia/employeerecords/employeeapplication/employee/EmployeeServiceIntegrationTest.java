//package com.macademia.employeerecords.employeeapplication.employee;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//import static com.macademia.employeerecords.employeeapplication.employee.EmployeeServiceDataBuilder.aSecondValidEmployee;
//import static com.macademia.employeerecords.employeeapplication.employee.EmployeeServiceDataBuilder.aValidEmployee;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@Transactional
//@RunWith(SpringJUnit4ClassRunner.class)
//public class EmployeeServiceIntegrationTest {
//
//    @Autowired
//    EmployeeRepository employeeRepository;
//
//    @Autowired
//    EmployeeService testee;
//
//    @Test
//    public void testCreateEmployee()
//    {
//        ResponseEntity<Employee> employeeResponse = testee.createEmployee(aValidEmployee());
//        assertEquals(HttpStatus.OK, employeeResponse.getStatusCode());
//        assertNotNull(employeeResponse.getBody());
//    }
//
//    @Test
//    public void testGetEmployee()
//    {
//        ResponseEntity<Employee> employeeResponse = testee.getEmployee(1);
//        assertEquals(HttpStatus.OK, employeeResponse.getStatusCode());
//        assertNotNull(employeeResponse.getBody());
//        assertEquals(1, employeeResponse.getBody().getId());
//    }
//
//    @Test
//    public void testGetAllEmployees()
//    {
//        testee.createEmployee(aValidEmployee());
//        testee.createEmployee(aSecondValidEmployee());
//        ResponseEntity<List<Employee>> employeeListResponse = testee.getAllEmployees();
//        assertEquals(HttpStatus.OK, employeeListResponse.getStatusCode());
//        assertNotNull(employeeListResponse.getBody());
//        assertEquals(1, employeeListResponse.getBody().get(0).getId());
//        assertEquals(2, employeeListResponse.getBody().get(0).getId());
//    }

    @Test
    public void testUpdateEmployee()
    {
        ResponseEntity<Employee> employee = testee.createEmployee(aValidEmployee());
        assertEquals(HttpStatus.OK, employee.getStatusCode());
        assertNotNull(employee.getBody());
    }

    @Test
    public void testDeleteEmployee()
    {
        ResponseEntity<Employee> employee = testee.createEmployee(aValidEmployee());
        assertEquals(HttpStatus.OK, employee.getStatusCode());
        assertNotNull(employee.getBody());
    }

    @Test
    public void testGetEmployeesByStartDateAndSalary()
    {
        ResponseEntity<Employee> employee = testee.createEmployee(aValidEmployee());
        assertEquals(HttpStatus.OK, employee.getStatusCode());
        assertNotNull(employee.getBody());
    }

    @Test
    public void testUpdateDepartmentOfficeLocation()
    {
        ResponseEntity<Employee> employee = testee.createEmployee(aValidEmployee());
        assertEquals(HttpStatus.OK, employee.getStatusCode());
        assertNotNull(employee.getBody());
    }

    @Test
    public void testGetWinner()
    {
        ResponseEntity<Employee> employee = testee.createEmployee(aValidEmployee());
        assertEquals(HttpStatus.OK, employee.getStatusCode());
        assertNotNull(employee.getBody());
    }
//}
