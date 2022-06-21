package com.github.beelencodingacademy.chinookwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

//    @GetMapping("/employee")
//    public String greeting(
//            @RequestParam(name="id", required=true) String employeeId, Model model) {
//
//        System.out.println(employeeId);
//
//        // Zoeken in de database
//        // Employee foundEmployee = employeeRepository.findByEmployeeId(employeeId);
//
//        model.addAttribute("firstName", "Marco");
//        model.addAttribute("lastName", "Beelen");
//
//        return "employee";
//    }

    @GetMapping("/employee/{id}")
    public String getEmployee(
            @PathVariable(name="id", required=true) Long employeeId, Model model) {

        System.out.println(employeeId);
            // Zoeken in de database
        Optional<Employee> foundEmployee = employeeRepository.findById(employeeId);

        if (foundEmployee.isPresent()) {
            model.addAttribute("employee", foundEmployee.get());
            return "employee";
        }


        return "unknownEmployee";
    }


}
