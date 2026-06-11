package com.cibermall.service;

import com.cibermall.DTO.DistritoDTO;
import com.cibermall.model.Distrito;
import com.cibermall.repository.IDistritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DistritoService {

    @Autowired
    private IDistritoRepository repoDistrito;

    public List<DistritoDTO> listarTodos() {
        return repoDistrito.findAll()
                .stream()
                .map(d -> new DistritoDTO(d.getIdDistrito(), d.getNombre(), d.getCostoEnvio()))
                .collect(Collectors.toList());
    }
}
