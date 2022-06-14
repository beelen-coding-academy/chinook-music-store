package com.github.mcbeelen.chinook;


import com.github.mcbeelen.chinook.repositories.Employee;
import com.github.mcbeelen.chinook.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class MusicStoreApplication implements CommandLineRunner {

    public MusicStoreApplication(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        showEmployeeInfo(1L);
        showEmployeeInfo(2L);
        showEmployeeInfo(0L);
        showEmployeeInfo(23432430L);

    }

    private void showEmployeeInfo(long id) {
        Optional<Employee> maybeEmployee = employeeRepository.findById(id);

        maybeEmployee
                .ifPresentOrElse(theEmployee -> System.out.println(theEmployee),
                        () -> System.err.println("No employee found"));
    }


    public static void main(String[] args) {
        SpringApplication.run(MusicStoreApplication.class, args);
    }

}
