package com.example.PcBuildingWeb.Controller;

import com.example.PcBuildingWeb.Service.service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class controller {
    private final service login_service;

    public controller(service login_service) {
        this.login_service = login_service;
    }

    @PostMapping("/login")
    public String log_in(@RequestParam String email, @RequestParam String password) {
        return login_service.login(email, password);
    }

    @PostMapping("/signup")
    public String sign_up(@RequestParam String email,
                          @RequestParam String password) {

        return login_service.sign_up(email, password);
    }
}
