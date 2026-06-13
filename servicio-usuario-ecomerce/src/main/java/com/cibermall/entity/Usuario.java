package com.cibermall.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Usuario {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    private String nombres;
	    private String apePaterno;
	    private String apeMaterno;
	    private String correo;
	    private String clave;
	    private String nroDoc;
	    private String direccion;
	    private String telefono;
	    private Boolean estado;
	    private LocalDateTime ultimoAcceso;
	    private LocalDateTime fechaActualizacion;
	    private LocalDateTime fechaRegistro;
	    @ManyToOne
	    private Distrito distrito;
	    @ManyToOne
	    private Rol rol;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getNombres() {
			return nombres;
		}
		public void setNombres(String nombres) {
			this.nombres = nombres;
		}
		public String getApePaterno() {
			return apePaterno;
		}
		public void setApePaterno(String apePaterno) {
			this.apePaterno = apePaterno;
		}
		public String getApeMaterno() {
			return apeMaterno;
		}
		public void setApeMaterno(String apeMaterno) {
			this.apeMaterno = apeMaterno;
		}
		public String getCorreo() {
			return correo;
		}
		public void setCorreo(String correo) {
			this.correo = correo;
		}
		public String getClave() {
			return clave;
		}
		public void setClave(String clave) {
			this.clave = clave;
		}
		public String getNroDoc() {
			return nroDoc;
		}
		public void setNroDoc(String nroDoc) {
			this.nroDoc = nroDoc;
		}
		public String getDireccion() {
			return direccion;
		}
		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}
		public String getTelefono() {
			return telefono;
		}
		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		public Boolean getEstado() {
			return estado;
		}
		public void setEstado(Boolean estado) {
			this.estado = estado;
		}
		public LocalDateTime getUltimoAcceso() {
			return ultimoAcceso;
		}
		public void setUltimoAcceso(LocalDateTime ultimoAcceso) {
			this.ultimoAcceso = ultimoAcceso;
		}
		public LocalDateTime getFechaActualizacion() {
			return fechaActualizacion;
		}
		public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
			this.fechaActualizacion = fechaActualizacion;
		}
		public LocalDateTime getFechaRegistro() {
			return fechaRegistro;
		}
		public void setFechaRegistro(LocalDateTime fechaRegistro) {
			this.fechaRegistro = fechaRegistro;
		}
		public Distrito getDistrito() {
			return distrito;
		}
		public void setDistrito(Distrito distrito) {
			this.distrito = distrito;
		}
		public Rol getRol() {
			return rol;
		}
		public void setRol(Rol rol) {
			this.rol = rol;
		}
	
	    
}
