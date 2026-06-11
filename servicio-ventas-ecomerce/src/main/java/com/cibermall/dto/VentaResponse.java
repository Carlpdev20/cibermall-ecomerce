package com.cibermall.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class VentaResponse {

    private Integer id;
    private Integer usuarioId;
    private BigDecimal total;
    private String estado;
    private LocalDateTime fechaRegistro;
    private List<DetalleVentaResponse> detalles;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public List<DetalleVentaResponse> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<DetalleVentaResponse> detalles) {
		this.detalles = detalles;
	}
    
    
}
