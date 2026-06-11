package com.cibermall.dto;

import java.math.BigDecimal;

public class ProductRequest {
	
	private String nombre;

    private String descripcion;

    private BigDecimal precio;

    private String imagen;

    private Integer categoriaId;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}

    
}

//{
//	  "nombre": "Laptop Lenovo i5",
//	  "descripcion": "15.6, 16GB RAM, 512GB SSD",
//	  "precio": 3299.90,
//	  "imagen": "/imgs/productos/laptop_01.webp",
//	  "categoriaId": 3,
//	  
//	}
