package com.example.PcBuildingWeb.Repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class repository {

    private final JdbcTemplate jdbcTemplate;

    public repository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // LOGIN
    public Map<String, Object> log_in(String email) {

        String sql = """
                SELECT user_id,
                       user_name,
                       user_email,
                       user_password,
                       user_image_url,
                       role
                FROM users
                WHERE user_email = ?
                """;

        return jdbcTemplate.queryForMap(sql, email);
    }

    // SIGN UP
    public int sign_up(String name,
                       String email,
                       String hashedPassword) {

        String sql = """
                INSERT INTO users
                (user_name, user_email, user_password, role)
                VALUES (?, ?, ?, 'USER')
                """;

        return jdbcTemplate.update(
                sql,
                name,
                email,
                hashedPassword
        );
    }
}