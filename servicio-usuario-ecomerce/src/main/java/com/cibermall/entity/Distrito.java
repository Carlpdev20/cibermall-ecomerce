package com.cibermall.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Distrito {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    private String nombre;
	    private BigDecimal costoEnvio;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public BigDecimal getCostoEnvio() {
			return costoEnvio;
		}

		public void setCostoEnvio(BigDecimal costoEnvio) {
			this.costoEnvio = costoEnvio;
		}
	    
	    
	
}
