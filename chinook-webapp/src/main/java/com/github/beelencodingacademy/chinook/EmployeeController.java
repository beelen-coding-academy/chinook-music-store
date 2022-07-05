package com.github.beelencodingacademy.chinook;

import com.github.beelencodingacademy.chinook.repositories.Employee;
import com.github.beelencodingacademy.chinook.repositories.EmployeeRepository;
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

    @GetMapping("/employee")
    public String employee(Model model) {
        Iterable<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "employees";
    }

    @GetMapping("/employee/{id}")
    public String getEmployee(
            @PathVariable(name="id", required=true) Long employeeId, Model model) {

        System.out.println(employeeId);
            // Zoeken in de database
        Optional<Employee> foundEmployee = employeeRepository.findById(employeeId);

        if (foundEmployee.isPresent()) {
            model.addAttribute("employee", foundEmployee.get());
            return "employeeDetails";
        }


        return "unknownEmployee";
    }


}
