package com.github.mcbeelen.chinook;


import com.github.javafaker.Faker;
import com.github.mcbeelen.chinook.repositories.Employee;
import com.github.mcbeelen.chinook.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@SpringBootApplication
public class MusicStoreApplication implements CommandLineRunner {

    public MusicStoreApplication(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
//        showEmployeeInfo(1L);
//        showEmployeeInfo(19L);
//        showEmployeeInfo(18L);
//        showEmployeeInfo(23432430L);
//        for (int i = 0; i < 5; i++) {
//        addNewEmployee();
//            // option + shift + pijltje omhoog
//        }
//        removeEmployee();
//        showEmployeeInfo(21L);

        List<Employee> employeeToFire = findEmployeeToFire();
        employeeRepository.deleteAll(employeeToFire);
            for (Employee e: employeeToFire){
                System.out.println(e);
            }
    }

    private List<Employee> findEmployeeToFire() {
        List<Employee> employeesToFire = employeeRepository.findByLastNameStartsWith("S");
        return employeesToFire;
    }

    private void removeEmployee() {
        employeeRepository.deleteById(19L);
    }

    private void addNewEmployee() {
        Employee employee = buildFakeEmployee();
        employeeRepository.save(employee);
        System.out.println(employee.getEmployeeId());
        System.out.println(employee);
        //sout

    }

    private Employee buildFakeEmployee() {
        Locale nl = new Locale("nl-NL");
        Faker faker = new Faker(nl);
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        Employee employee = new Employee();
        // dat doe je met option + command + v
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        return employee;
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
