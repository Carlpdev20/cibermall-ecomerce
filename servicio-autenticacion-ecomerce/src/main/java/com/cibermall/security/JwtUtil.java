package com.cibermall.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Component
public class JwtUtil {

    // Llave secreta en texto plano (Debe tener al menos 32 bytes/caracteres para ser segura)
    private static final String SECRET_STRING = "mi_clave_super_secreta_de_32_bytes!!";
    private SecretKey key;

    /**
     * Este método se ejecuta automáticamente una sola vez cuando Spring levanta el componente.
     * Transforma el texto secreto en una llave criptográfica real usando el algoritmo HMAC.
     */
    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(SECRET_STRING.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Genera un token JWT firmado para el usuario que se logueó con éxito.
     */
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username) // Guardamos el correo del usuario dentro del token
                .setIssuedAt(new Date()) // Fecha de creación (Ahorita mismo)
                // Expiración: Tiempo actual + 3'600,000 milisegundos (Equivale a 1 hora de validez)
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(key, SignatureAlgorithm.HS256) // Firmamos digitalmente el token con nuestra llave
                .compact(); // Compacta todo en la cadena de texto de tres partes separadas por puntos
    }

    /**
     * Abre el token utilizando la llave secreta para leer el contenido de su "carga útil" (Claims).
     */
    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key) // Le damos la llave para verificar que nadie haya manipulado el token
                .build()
                .parseClaimsJws(token)
                .getBody(); // Extrae la información interna (Subject, Expiración, etc.)
    }
    
    /**
     * Verifica si el token es válido comparando el Subject (correo) con el usuario logueado.
     */
    public boolean validateToken(String token, String username) {
        try {
            // Si el correo guardado dentro del token es igual al que hace la petición, es válido
            return getClaims(token).getSubject().equals(username);
        } catch (JwtException | IllegalArgumentException e) {
            // Si el token expiró, la firma es falsa o está corrupto, atrapa el error y niega el acceso
            return false;
        }
    }
}