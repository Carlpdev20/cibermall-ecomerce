package com.cibermall.dto;

import java.util.List;

import lombok.Data;

@Data
public class VentaRequest {

    private Integer usuarioId;
    private List<DetalleVentaRequest> detalles;

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public List<DetalleVentaRequest> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleVentaRequest> detalles) {
		this.detalles = detalles;
	}
    
    
}
