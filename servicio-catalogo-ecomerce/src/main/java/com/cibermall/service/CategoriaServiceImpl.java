package com.cibermall.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibermall.dto.CategoriaRequest;
import com.cibermall.dto.CategoriaResponse;
import com.cibermall.entity.Categoria;
import com.cibermall.mapper.Mapper;
import com.cibermall.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	private final CategoriaRepository categoriaRepository;
	private final Mapper mapper;
	
	public CategoriaServiceImpl(CategoriaRepository categoriaRepository,
			Mapper mapper) {
		this.categoriaRepository = categoriaRepository;
		this.mapper = mapper;
	}
	@Override
	public CategoriaResponse create(CategoriaRequest request) {
		Categoria categoria = mapper.toCategoria(request);
		categoriaRepository.save(categoria);
		return mapper.toResponseCategoria(categoria);
	}

	@Override
	public CategoriaResponse findById(Integer id) {
		Categoria categoria = categoriaRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Categoria no existe"));
		return mapper.toResponseCategoria(categoria);
	}

	@Override
	public List<CategoriaResponse> findAll() {
		return categoriaRepository.findAll()
				.stream()
				.map(mapper::toResponseCategoria).toList();
	
	}
	 
}
