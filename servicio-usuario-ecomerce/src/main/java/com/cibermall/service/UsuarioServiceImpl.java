package com.cibermall.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cibermall.dto.UsuarioRequest;
import com.cibermall.dto.UsuarioResponse;
import com.cibermall.entity.Distrito;
import com.cibermall.entity.Rol;
import com.cibermall.entity.Usuario;
import com.cibermall.mapper.Mapper;
import com.cibermall.repository.DistritoRepository;
import com.cibermall.repository.RolRepository;
import com.cibermall.repository.UsuarioRepository;

@Service

public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final DistritoRepository distritoRepository;
    private final RolRepository rolRepository;
    private final Mapper mapper;
    
    
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, DistritoRepository distritoRepository,
			RolRepository rolRepository, Mapper mapper) {
		super();
		this.usuarioRepository = usuarioRepository;
		this.distritoRepository = distritoRepository;
		this.rolRepository = rolRepository;
		this.mapper = mapper;
	}

	@Override
    public UsuarioResponse create(UsuarioRequest request) {

        if (usuarioRepository.existsByCorreo(request.getCorreo())) {
            throw new RuntimeException("El correo ya está registrado");
        }

        if (usuarioRepository.existsByNroDoc(request.getNroDoc())) {
            throw new RuntimeException("El número de documento ya está registrado");
        }

        Distrito distrito = distritoRepository.findById(request.getDistritoId())
                .orElseThrow(() -> new RuntimeException("Distrito no encontrado"));

        Rol rol = rolRepository.findById(request.getRolId())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        Usuario usuario = mapper.toUsuario(request, distrito, rol);

        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        return mapper.toResponse(usuarioGuardado);
    }

    @Override
    public UsuarioResponse findById(Integer id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return mapper.toResponse(usuario);
    }

    @Override
    public List<UsuarioResponse> findAll() {

        return usuarioRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public void delete(Integer id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuario.setEstado(false);
        usuario.setFechaActualizacion(LocalDateTime.now());

        usuarioRepository.save(usuario);
    }
}
