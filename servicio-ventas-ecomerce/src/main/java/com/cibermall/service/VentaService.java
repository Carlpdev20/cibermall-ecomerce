package com.cibermall.service;

import java.util.List;

import com.cibermall.dto.VentaRequest;
import com.cibermall.dto.VentaResponse;

public interface VentaService {

    VentaResponse create(VentaRequest request);

    VentaResponse findById(Integer id);

    List<VentaResponse> findAll();

    List<VentaResponse> findByUsuarioId(Integer usuarioId);
}
