package com.cibermall.DTO;

import lombok.Data;

@Data
public class RegistroUsuarioDTO {
    private String correo;
    private String clave;
    private String nombres;
    private String apePaterno;
    private String apeMaterno;
    private String nroDoc;
    private String telefono;
    private String direccion;
    private Integer idDistrito;
    private String rol; 
}