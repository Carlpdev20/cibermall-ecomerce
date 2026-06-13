package com.cibermall.service;

import java.util.List;

import com.cibermall.dto.CategoriaRequest;
import com.cibermall.dto.CategoriaResponse;

public interface CategoriaService {
	CategoriaResponse create(CategoriaRequest request);

    CategoriaResponse findById(Integer id);

    List<CategoriaResponse> findAll();
}
