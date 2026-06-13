package com.cibermall.service;

import org.springframework.stereotype.Service;

import com.cibermall.dto.ProductRequest;
import com.cibermall.dto.ProductResponse;
import com.cibermall.entity.Categoria;
import com.cibermall.entity.Product;
import com.cibermall.mapper.Mapper;
import com.cibermall.repository.CategoriaRepository;
import com.cibermall.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productorepository;
	private final CategoriaRepository categoriarepository;
	private final Mapper mapper;
	
	public ProductServiceImpl(ProductRepository productorepository,
	CategoriaRepository categoriarepository,
	Mapper mapper) {
		this.productorepository = productorepository ;
		this.categoriarepository = categoriarepository;
		this.mapper = mapper;
	}
	
	@Override
	public ProductResponse create(ProductRequest request) {
		Categoria categoria = categoriarepository.findById(request.getCategoriaId())
				.orElseThrow(()-> new RuntimeException("Categoria no encontrada"));
		
		Product product = mapper.toProduct(request, categoria);
		productorepository.save(product);
		return mapper.toResponseProducto(product);
	}

	@Override
	public ProductResponse findById(Integer id) {
		Product product =  productorepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Producto no encontrado") );
		
		return mapper.toResponseProducto(product);
	}
		
}
