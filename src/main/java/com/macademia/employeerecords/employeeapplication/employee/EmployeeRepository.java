package com.macademia.employeerecords.employeeapplication.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findEmployeesByStartDateAfterAndSalaryGreaterThan(Date startDate, BigDecimal salary);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value="UPDATE EMPLOYEE em SET em.OFFICE_LOCATION =:officeLocation where em.DEPARTMENT=:department", nativeQuery = true)
    void updateOfficeLocationByDepartment(@Param("department") String department, @Param("officeLocation") String officeLocation);

    @Query(value="SELECT * FROM Employee em WHERE em.winner IS TRUE", nativeQuery = true)
    Employee getMonthlyWinner();

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value="UPDATE EMPLOYEE em SET em.WINNER = FALSE", nativeQuery = true)
    void resetWinner();

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value="UPDATE EMPLOYEE em SET em.WINNER = TRUE where em.id=:id", nativeQuery = true)
    void updateWinner(@Param("id") Integer id);
}
