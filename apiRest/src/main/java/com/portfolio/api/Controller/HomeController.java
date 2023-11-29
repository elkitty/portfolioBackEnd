package com.portfolio.api.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class HomeController {

    @Autowired
    @GetMapping("/home")
    public String home() {
        return "home"; // o el contenido deseado
    }
}
