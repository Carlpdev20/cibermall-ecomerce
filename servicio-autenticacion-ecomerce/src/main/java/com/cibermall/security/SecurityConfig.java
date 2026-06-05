package com.cibermall.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    
    @Autowired
    private JwtFilter jwtFilter;
    
    /**
     * El oleoducto (Pipeline) de Seguridad.
     * Aquí definimos qué reglas debe seguir cada petición HTTP que entra al servidor.
     */
    @Bean
    public SecurityFilterChain filterchain(HttpSecurity http) throws Exception {
        http
            // 1. Deshabilitar CSRF (Cross-Site Request Forgery)
            .csrf(csrf -> csrf.disable())	
            
            // 2. Control de accesos a URLs
            .authorizeHttpRequests(auth -> auth
                    // Permitimos acceso total al Login y rutas públicas sin pedir tokens
                    .requestMatchers("/api/pub", "/auth/login").permitAll()
                    // Cualquier otra ruta obligatoriamente requerirá estar autenticado
                    .anyRequest().authenticated()
            )
            
            // 3. Inyectar nuestro guardián personalizado en la fila de filtros
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        
        return http.build();
    }

    /**
     * El motor de cifrado oficial exigido por la guía para procesar contraseñas hash.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public org.springframework.boot.CommandLineRunner generarHashPrueba(PasswordEncoder encoder) {
        return args -> {
            System.out.println("==========================================================");
            System.out.println("👇 TU HASH REAL DE CIBERMALL ES ESTE 👇");
            System.out.println(encoder.encode("clave123"));
            System.out.println("==========================================================");
        };
    }
}