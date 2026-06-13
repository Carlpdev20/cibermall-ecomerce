package com.cibermall.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibermall.DTO.LoginDTO;
import com.cibermall.DTO.RegistroUsuarioDTO;
import com.cibermall.model.Usuario;
import com.cibermall.service.UsuarioService;
import com.cibermall.security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    // POST /auth/registrar
    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody RegistroUsuarioDTO dto) {
        try {
            // Forzar rol CLIENTE siempre desde el registro público
            dto.setRol(1);
            Usuario usuarioCreado = usuarioService.registrarUsuario(dto);
            // No devolver la clave encriptada
            usuarioCreado.setClave(null);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCreado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // POST /auth/login  — devuelve token + datos básicos del usuario
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO dto) {
        try {
            Usuario usuarioLogueado = usuarioService.login(dto);
            String token = jwtUtil.generateToken(usuarioLogueado.getCorreo());

            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("token",    token);
            respuesta.put("correo",   usuarioLogueado.getCorreo());
            respuesta.put("nombres",  usuarioLogueado.getNombres());
            respuesta.put("rol",      usuarioLogueado.getRol());

            return ResponseEntity.ok(respuesta);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
