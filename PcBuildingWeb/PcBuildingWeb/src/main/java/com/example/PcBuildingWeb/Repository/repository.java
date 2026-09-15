package com.example.PcBuildingWeb.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class repository {
    private final JdbcTemplate jdbcTemplate;
    public repository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public String log_in(String email) {

        String sql = """
                SELECT user_password
                FROM users
                WHERE user_email = ?
                """;

        return jdbcTemplate.queryForObject(
                sql,
                String.class,
                email
        );
    }
    public int sign_up(String email, String hashedPassword) {

        String sql = """
            INSERT INTO users (user_email, user_password)
            VALUES (?, ?)
            """;

        return jdbcTemplate.update(
                sql,
                email,
                hashedPassword
        );
    }
}
