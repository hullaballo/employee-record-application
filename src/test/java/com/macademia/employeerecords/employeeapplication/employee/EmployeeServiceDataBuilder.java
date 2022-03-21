package com.macademia.employeerecords.employeeapplication.employee;

import java.math.BigDecimal;
import java.sql.Date;

import static java.lang.Boolean.FALSE;

public class EmployeeServiceDataBuilder {

    private static final Integer ID_1 = 1;
    private static final Integer ID_2 = 1;
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String OFFICE_LOCATION = "officeLocation";
    private static final String DEPARTMENT = "department";
    private static final BigDecimal SALARY = BigDecimal.valueOf(30000);
    private static final Date START_DATE = new Date(System.currentTimeMillis());
    private static final Boolean WINNER = FALSE;

    protected static Employee aValidEmployee() {
        return new Employee(ID_1, FIRST_NAME, LAST_NAME, OFFICE_LOCATION, DEPARTMENT, SALARY, START_DATE, WINNER);
    }

    protected static Employee aSecondValidEmployee() {
        return new Employee(ID_2, FIRST_NAME, LAST_NAME, OFFICE_LOCATION, DEPARTMENT, SALARY, START_DATE, WINNER);
    }
}
