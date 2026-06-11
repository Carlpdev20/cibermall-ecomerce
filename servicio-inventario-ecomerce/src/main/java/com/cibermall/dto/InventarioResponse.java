package com.cibermall.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class InventarioResponse {

    private Integer id;
    private Integer productoId;
    private Integer stock;
    private Integer stockReservado;
    private Integer stockDisponible;
    private Boolean estado;
    private LocalDateTime fechaRegistro;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public Integer getStockReservado() {
		return stockReservado;
	}
	public void setStockReservado(Integer stockReservado) {
		this.stockReservado = stockReservado;
	}
	public Integer getStockDisponible() {
		return stockDisponible;
	}
	public void setStockDisponible(Integer stockDisponible) {
		this.stockDisponible = stockDisponible;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
    
    
}
