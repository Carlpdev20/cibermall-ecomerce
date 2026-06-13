package com.cibermall.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UsuarioResponse {

	    private Integer id;
	    private String nombres;
	    private String apePaterno;
	    private String apeMaterno;
	    private String correo;
	    private String nroDoc;
	    private String direccion;
	    private String telefono;
	    private Boolean estado;
	    private LocalDateTime fechaRegistro;
	    private Integer distritoId;
	    private String distritoNombre;
	    private BigDecimal costoEnvio;
	    private Integer rolId;
	    private String rolCodigo;
	    private String rolDescripcion;
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
		public LocalDateTime getFechaRegistro() {
			return fechaRegistro;
		}
		public void setFechaRegistro(LocalDateTime fechaRegistro) {
			this.fechaRegistro = fechaRegistro;
		}
		public Integer getDistritoId() {
			return distritoId;
		}
		public void setDistritoId(Integer distritoId) {
			this.distritoId = distritoId;
		}
		public String getDistritoNombre() {
			return distritoNombre;
		}
		public void setDistritoNombre(String distritoNombre) {
			this.distritoNombre = distritoNombre;
		}
		public BigDecimal getCostoEnvio() {
			return costoEnvio;
		}
		public void setCostoEnvio(BigDecimal costoEnvio) {
			this.costoEnvio = costoEnvio;
		}
		public Integer getRolId() {
			return rolId;
		}
		public void setRolId(Integer rolId) {
			this.rolId = rolId;
		}
		public String getRolCodigo() {
			return rolCodigo;
		}
		public void setRolCodigo(String rolCodigo) {
			this.rolCodigo = rolCodigo;
		}
		public String getRolDescripcion() {
			return rolDescripcion;
		}
		public void setRolDescripcion(String rolDescripcion) {
			this.rolDescripcion = rolDescripcion;
		}
	    
	
}
