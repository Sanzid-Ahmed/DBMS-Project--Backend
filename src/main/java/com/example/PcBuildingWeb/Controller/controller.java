package com.example.PcBuildingWeb.Controller;

import com.example.PcBuildingWeb.Service.service;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class controller {

    private final service login_service;

    public controller(service login_service) {
        this.login_service = login_service;
    }


    // LOGIN
    @PostMapping("/login")
    public Map<String, Object> log_in(
            @RequestParam String email,
            @RequestParam String password) {

        return login_service.login(email, password);
    }


    // SIGN UP
    @PostMapping("/signup")
    public String sign_up(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password) {

        return login_service.sign_up(
                name,
                email,
                password
        );
    }
}