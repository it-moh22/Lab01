package com.champsoft.cardealershipwebapp_v2.employeemanagementsubdomain.DataLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e WHERE e.employeeIdentifier = :employeeIdentifier")
    Optional<Employee> findByEmployeeIdentifier(@Param("supplierIdentifier") String employeeIdentifier);
}

