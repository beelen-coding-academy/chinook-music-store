package com.github.mcbeelen.chinook.repositories;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "Employee")
public class Employee {

    @Id
    @Column("EmployeeId")
    private Integer employeeId;

    @Column("FirstName")
    private String firstName;
    @Column("LastName")
    private String lastName;


    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
