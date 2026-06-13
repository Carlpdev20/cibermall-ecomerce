package com.cibermall.service;

import java.util.List;

import com.cibermall.dto.UsuarioRequest;
import com.cibermall.dto.UsuarioResponse;

public interface UsuarioService {

    UsuarioResponse create(UsuarioRequest request);

    UsuarioResponse findById(Integer id);

    List<UsuarioResponse> findAll();

    void delete(Integer id);
}
