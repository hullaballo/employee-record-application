package com.macademia.employeerecords.employeeapplication.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name="Employee")
@Table(name="Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name ="first_name", nullable = false)
    private String firstName;

    @Column(name ="last_name", nullable = false)
    private String lastName;

    @Column(name = "office_location", nullable = false)
    private String officeLocation;

    @Column(name ="department", nullable = false)
    private String department;

    @Column(name ="salary", nullable = false)
    private BigDecimal salary;

    @Column(name ="start_date", nullable = false)
    private Date startDate;

    @Column(name ="winner")
    private Boolean winner = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(officeLocation, employee.officeLocation) && Objects.equals(department, employee.department) && Objects.equals(salary, employee.salary) && Objects.equals(startDate, employee.startDate) && Objects.equals(winner, employee.winner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, officeLocation, department, salary, startDate, winner);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", officeLocation='" + officeLocation + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", startDate=" + startDate +
                ", winner=" + winner +
                '}';
    }
}
