package com.cibermall.dto;

import lombok.Data;

@Data
public class InventarioRequest {

    private Integer productoId;
    private Integer stock;
	public Integer getProductoId() {
		return productoId;
	}
	public void setProductoId(Integer productoId) {
		this.productoId = productoId;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
    
    
}
