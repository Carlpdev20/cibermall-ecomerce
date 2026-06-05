package com.cibermall.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PruebaController {
    
    /**
     * Endpoint Libre. Mapeado a "/api/pub".
     * Al estar declarado en el 'requestMatchers' del SecurityConfig como permitAll,
     * cualquier cliente (incluido Angular o Postman) puede entrar sin enviar token.
     */
    @GetMapping("/pub")
    public ResponseEntity<String> publicEndPoint() {
        return ResponseEntity.ok("Este es un Endpoint público y libre de tokens. ¡Bienvenidos a Cibermall!");
    }
    
    /**
     * Endpoint Protegido. Mapeado a "/api/prueba/private".
     * Al caer en la regla 'anyRequest().authenticated()', el JwtFilter obligatoriamente
     * buscará un token válido en la cabecera, o de lo contrario el servidor arrojará un 403 Forbidden.
     */
    @GetMapping("/prueba/private")
    public ResponseEntity<String> privateEndPoint() {
        return ResponseEntity.ok("Este es un endpoint privado de alta seguridad. ¡Tu Token JWT es completamente válido!");
    }
}