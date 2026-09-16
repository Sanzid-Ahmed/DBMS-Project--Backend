package com.example.PcBuildingWeb.Service;

import com.example.PcBuildingWeb.Repository.repository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class service {

    private final BCryptPasswordEncoder encoder;
    private final repository login_repo;

    public service(repository login_repo) {
        this.login_repo = login_repo;
        this.encoder = new BCryptPasswordEncoder();
    }


    // LOGIN
    public Map<String, Object> login(String email, String password) {

        try {

            Map<String, Object> user = login_repo.log_in(email);

            String storedHash = (String) user.get("user_password");

            if (storedHash != null && encoder.matches(password, storedHash)) {

                // Information that will be sent to frontend
                Map<String, Object> response = new HashMap<>();

                response.put("userId", user.get("user_id"));
                response.put("userName", user.get("user_name"));
                response.put("userEmail", user.get("user_email"));
                response.put("userImageUrl", user.get("user_image_url"));
                response.put("role", user.get("role"));

                return response;
            }

        } catch (Exception e) {
            // User doesn't exist or database error
        }

        Map<String, Object> response = new HashMap<>();

        response.put("message", "Invalid email or password");

        return response;
    }


    // SIGN UP
    public String sign_up(String name,
                          String email,
                          String password) {

        try {

            String hashedPassword = encoder.encode(password);

            int result = login_repo.sign_up(
                    name,
                    email,
                    hashedPassword
            );

            if (result == 1) {
                return "Account created successfully";
            }

        } catch (Exception e) {

            e.printStackTrace();

            return "Account creation failed";
        }

        return "Account creation failed";
    }
}