package com.portfolio.api.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthController {
    
    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        // Lógica para cerrar sesión en el lado del servidor

        // Envía un mensaje indicando el éxito del logout y que el token debe ser eliminado
        String responseMessage = "Logout exitoso. Elimina el token en el front-end.";

        return ResponseEntity.ok(responseMessage);
    }
    
}
