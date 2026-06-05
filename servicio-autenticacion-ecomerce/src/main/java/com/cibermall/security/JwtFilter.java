package com.cibermall.security;

import java.io.IOException;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        // 1. Extraer la cabecera llamada "Authorization" de la petición HTTP
        String authHeader = request.getHeader("Authorization");

        // 2. Verificar si la cabecera existe y empieza con la palabra "Bearer "
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // Recortar el texto "Bearer " (que tiene 7 caracteres) para quedarnos solo con el Token puro
            String jwt = authHeader.substring(7);
            
            try {
                // 3. Abrir el token y extraer la información de su interior (Claims)
                Claims claims = jwtUtil.getClaims(jwt);
                String username = claims.getSubject(); // Aquí viene el correo del usuario

                // 4. Si el token es válido, le creamos su credencial de acceso para Spring Security
                // Por ahora, tu código base le asigna un permiso genérico llamado "USER"
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        username, 
                        null,
                        Collections.singleton(new SimpleGrantedAuthority("USER"))
                );

                // 5. Inyectar al usuario autenticado dentro del contexto de seguridad de Spring
                SecurityContextHolder.getContext().setAuthentication(auth);
                
            } catch (Exception e) {
                // Si el token expiró o es falso, el catch atrapa el error 
                // y la petición continuará sin estar autenticada (dará un error 403 o 401 más adelante)
                logger.error("No se pudo establecer la autenticación de usuario: " + e.getMessage());
            }
        }

        // 6. Dejar que la petición continúe su camino hacia el Controlador (endpoint)
        filterChain.doFilter(request, response);
    }
}