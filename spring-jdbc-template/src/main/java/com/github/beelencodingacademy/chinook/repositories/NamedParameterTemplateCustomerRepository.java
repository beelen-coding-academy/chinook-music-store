package com.github.beelencodingacademy.chinook.repositories;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class NamedParameterTemplateCustomerRepository implements CustomerRepository {

    private final NamedParameterJdbcOperations jdbcOperations;
    private final SimpleJdbcInsert jdbcInsert;

    public NamedParameterTemplateCustomerRepository(DataSource dataSource) {
        this.jdbcOperations = new NamedParameterJdbcTemplate(dataSource);
        jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("CUSTOMER");
    }

    @Override
    public void save(Customer customer) {

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("FirstName", customer.getFirstName());
        parameters.put("LastName", customer.getLastName());

        jdbcInsert.execute(parameters);


    }
}
