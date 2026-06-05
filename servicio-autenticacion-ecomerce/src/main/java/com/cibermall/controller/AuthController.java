package com.cibermall.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibermall.model.Usuario;
import com.cibermall.repository.UsuarioRepository;
import com.cibermall.security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> body) {

        // Extraemos las credenciales que vienen desde el formulario de Angular
        String correo = body.get("correo");
        String clave = body.get("clave");

        // 1. Buscar al usuario en la base de datos por su correo electrónico
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreo(correo);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();

            // 2. Comprobar si la contraseña coincide usando el verificador de BCrypt
            if (passwordEncoder.matches(clave, usuario.getClave())) {
            	
                // 3. Si todo es correcto, generamos su token JWT firmado
                String token = jwtUtil.generateToken(usuario.getCorreo());
                
                // Retornamos el token en formato JSON {"token": "ey..."}
                return ResponseEntity.ok(Map.of("token", token));
            }
        }

        // Si el usuario no existe o la contraseña no coincide, devolvemos 401 (No Autorizado)
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}