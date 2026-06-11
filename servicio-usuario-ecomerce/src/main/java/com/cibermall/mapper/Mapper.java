package com.cibermall.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.cibermall.dto.UsuarioRequest;
import com.cibermall.dto.UsuarioResponse;
import com.cibermall.entity.Distrito;
import com.cibermall.entity.Rol;
import com.cibermall.entity.Usuario;

@Component
public class Mapper {

	    public Usuario toUsuario(UsuarioRequest request,
	            Distrito distrito,
	            Rol rol) {
	        Usuario usuario = new Usuario();

	        usuario.setNombres(request.getNombres());
	        usuario.setApePaterno(request.getApePaterno());
	        usuario.setApeMaterno(request.getApeMaterno());
	        usuario.setCorreo(request.getCorreo());
	        usuario.setClave(request.getClave());
	        usuario.setNroDoc(request.getNroDoc());
	        usuario.setDireccion(request.getDireccion());
	        usuario.setTelefono(request.getTelefono());
	        usuario.setDistrito(distrito);
	        usuario.setRol(rol);
	        usuario.setEstado(true);
	        usuario.setFechaRegistro(LocalDateTime.now());

	        return usuario;
	    }

	    public UsuarioResponse toResponse(Usuario usuario) {
	        UsuarioResponse response = new UsuarioResponse();

	        response.setId(usuario.getId());
	        response.setNombres(usuario.getNombres());
	        response.setApePaterno(usuario.getApePaterno());
	        response.setApeMaterno(usuario.getApeMaterno());
	        response.setCorreo(usuario.getCorreo());
	        response.setNroDoc(usuario.getNroDoc());
	        response.setDireccion(usuario.getDireccion());
	        response.setTelefono(usuario.getTelefono());
	        response.setEstado(usuario.getEstado());
	        response.setFechaRegistro(usuario.getFechaRegistro());

	        response.setDistritoId(usuario.getDistrito().getId());
	        response.setDistritoNombre(usuario.getDistrito().getNombre());
	        response.setCostoEnvio(usuario.getDistrito().getCostoEnvio());

	        response.setRolId(usuario.getRol().getId());
	        response.setRolCodigo(usuario.getRol().getCodigo());
	        response.setRolDescripcion(usuario.getRol().getDescripcion());

	        return response;
	    }
	
}
