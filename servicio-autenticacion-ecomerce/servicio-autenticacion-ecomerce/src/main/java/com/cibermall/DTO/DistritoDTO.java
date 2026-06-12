package com.cibermall.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistritoDTO {
    private Integer idDistrito;
    private String nombre;
    private Double costoEnvio;


	public DistritoDTO(Integer idDistrito, String nombre, Double costoEnvio) {
		super();
		this.idDistrito = idDistrito;
		this.nombre = nombre;
		this.costoEnvio = costoEnvio;
	}
	public Integer getIdDistrito() {
		return idDistrito;
	}
	public void setIdDistrito(Integer idDistrito) {
		this.idDistrito = idDistrito;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getCostoEnvio() {
		return costoEnvio;
	}
	public void setCostoEnvio(Double costoEnvio) {
		this.costoEnvio = costoEnvio;
	}
    
    
}
