package com.company.assignment3_singleton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class DatabaseConnectionApp {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DatabaseConnectionApp.class, args);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        int rowCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM cars", Integer.class);

        String insertQuery = "INSERT INTO cars (brand, model, year) VALUES (?, ?, ?)";
        jdbcTemplate.update(insertQuery, "Mercedes-Benz", "GLE Coupe", 2023);

        String selectQuery = "SELECT * FROM cars WHERE brand = ?";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(selectQuery, "Mercedes-Benz");

        for (Map<String, Object> row : rows) {
            String brand = (String) row.get("brand");
            String model = (String) row.get("model");
            int year = (int) row.get("year");

            System.out.println(brand + " " + model + " " + year);
        }

        System.out.println("Total rows in the table: " + rowCount);
    }
}
