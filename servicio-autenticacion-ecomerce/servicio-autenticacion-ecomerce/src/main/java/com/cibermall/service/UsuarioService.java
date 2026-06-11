package com.cibermall.service;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.cibermall.DTO.LoginDTO;
import com.cibermall.DTO.RegistroUsuarioDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.cibermall.model.Usuario;
import com.cibermall.repository.IUsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private IUsuarioRepository repoUsuario;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder; 

	public Usuario registrarUsuario(RegistroUsuarioDTO dto) {
	    
	    if (repoUsuario.findByCorreo(dto.getCorreo()).isPresent()) {
	        throw new RuntimeException("El correo electrónico ya está registrado");
	    }

	    Usuario usuario = new Usuario();
	    usuario.setCorreo(dto.getCorreo());
	    usuario.setNombres(dto.getNombres());
	    usuario.setApePaterno(dto.getApePaterno());
	    usuario.setApeMaterno(dto.getApeMaterno());
	    usuario.setNroDoc(dto.getNroDoc());
	    usuario.setTelefono(dto.getTelefono());
	    usuario.setDireccion(dto.getDireccion());
	    usuario.setIdDistrito(dto.getIdDistrito());
	    usuario.setRol(dto.getRol());
	    usuario.setFechaRegistro(LocalDateTime.now());
	    usuario.setEstado(1); 
	    usuario.setClave(passwordEncoder.encode(dto.getClave()));

	    return repoUsuario.save(usuario);
	}

	public Usuario login(LoginDTO dto) {
	    
	    Usuario usuario = repoUsuario.findByCorreo(dto.getCorreo())
	            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

	    if (!passwordEncoder.matches(dto.getClave(), usuario.getClave())) {
	        throw new RuntimeException("Contraseña incorrecta");
	    }

	    usuario.setUltimoAcceso(LocalDateTime.now());
	    repoUsuario.save(usuario);

	    return usuario;
	}
}