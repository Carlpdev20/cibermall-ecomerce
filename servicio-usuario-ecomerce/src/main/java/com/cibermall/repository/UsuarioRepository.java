package com.cibermall.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibermall.entity.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer>  {
    boolean existsByCorreo(String correo);
    boolean existsByNroDoc(String nroDoc);
    Optional<Usuario> findByCorreo(String correo);
	
}
