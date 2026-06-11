package com.cibermall.dto;

import lombok.Data;

@Data
public class UsuarioRequest {

	    private String nombres;
	    private String apePaterno;
	    private String apeMaterno;
	    private String correo;
	    private String clave;
	    private String nroDoc;
	    private String direccion;
	    private Integer distritoId;
	    private String telefono;
	    private Integer rolId;
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
		public Integer getDistritoId() {
			return distritoId;
		}
		public void setDistritoId(Integer distritoId) {
			this.distritoId = distritoId;
		}
		public String getTelefono() {
			return telefono;
		}
		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		public Integer getRolId() {
			return rolId;
		}
		public void setRolId(Integer rolId) {
			this.rolId = rolId;
		}
	    
	
}
