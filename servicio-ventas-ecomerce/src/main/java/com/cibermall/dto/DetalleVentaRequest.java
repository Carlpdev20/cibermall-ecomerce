package com.cibermall.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class DetalleVentaRequest {

    private Integer productoId;
    private Integer cantidad;
    private BigDecimal precioUnitario;
	public Integer getProductoId() {
		return productoId;
	}
	public void setProductoId(Integer productoId) {
		this.productoId = productoId;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
    
}
