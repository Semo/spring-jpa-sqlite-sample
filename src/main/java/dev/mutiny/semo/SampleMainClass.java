package dev.mutiny.semo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

@SpringBootApplication
public class SampleMainClass implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public SampleMainClass(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleMainClass.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SqlRowSet resultSet = jdbcTemplate.queryForRowSet("SELECT * FROM employees");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("FirstName"));
        }
    }
}
