package com.cibermall.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.cibermall.dto.CategoriaRequest;
import com.cibermall.dto.CategoriaResponse;
import com.cibermall.dto.ProductRequest;
import com.cibermall.dto.ProductResponse;
import com.cibermall.entity.Categoria;
import com.cibermall.entity.Product;

@Component
public class Mapper {
		public ProductResponse toResponseProducto(Product product) {
			ProductResponse response = new ProductResponse();
			response.setId(product.getId());
		    response.setNombre(product.getNombre());
		    response.setDescripcion(product.getDescripcion());
		    response.setPrecio(product.getPrecio());
		    response.setImagen(product.getImagen());
		    response.setEstado(product.getEstado());
		    response.setFechaRegistro(product.getFechaRegistro());
			
			response.setCategoriaId(product.getCategoria().getId());
			response.setCategoriaDescripcion(product.getCategoria().getDescripcion());
			
			return response;
		}
		
		public Product toProduct(ProductRequest request, Categoria categoria) {
			Product product = new Product();
			product.setNombre(request.getNombre());
			product.setDescripcion(request.getDescripcion());
			product.setImagen(request.getImagen());
			product.setPrecio(request.getPrecio());
			product.setCategoria(categoria);
			product.setEstado(true);
			product.setFechaRegistro(LocalDateTime.now());
			return product;
		}
	
		public Categoria toCategoria(CategoriaRequest request) {

	        Categoria categoria = new Categoria();
	        categoria.setDescripcion(request.getDescripcion());
	        categoria.setEstado(true);
	        categoria.setFechaRegistro(LocalDateTime.now());

	        return categoria;
	    }

	    public CategoriaResponse toResponseCategoria(Categoria categoria) {

	        CategoriaResponse response = new CategoriaResponse();

	        response.setId(categoria.getId());
	        response.setDescripcion(categoria.getDescripcion());
	        response.setEstado(categoria.getEstado());
	        response.setFechaRegistro(categoria.getFechaRegistro());

	        return response;
	    }
		
}
