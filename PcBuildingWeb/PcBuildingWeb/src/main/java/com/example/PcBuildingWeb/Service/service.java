package com.example.PcBuildingWeb.Service;
import com.example.PcBuildingWeb.Repository.repository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class service{
    private final BCryptPasswordEncoder encoder;
    private final repository login_repo;
    public service(repository login_repo) {
        this.login_repo = login_repo;
        this.encoder = new BCryptPasswordEncoder();
    }

    public String login(String email, String password) {

        String storedHash = login_repo.log_in(email);

        if (storedHash != null && encoder.matches(password, storedHash)) {
            return "Login Successfully";
        }

        return "Invalid email or password";
    }
    public String sign_up(String email, String password) {

        String hashedPassword = encoder.encode(password);

        int result = login_repo.sign_up(email, hashedPassword);

        if (result == 1) {
            return "Account created successfully";
        }

        return "Account creation failed";
    }
}