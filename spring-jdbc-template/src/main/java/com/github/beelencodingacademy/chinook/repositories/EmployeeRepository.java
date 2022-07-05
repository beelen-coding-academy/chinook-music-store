package com.github.beelencodingacademy.chinook.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

    List<Employee> findByLastNameStartsWith(String lastName);

    //zoek standaard zinnetjes op website spring
}

