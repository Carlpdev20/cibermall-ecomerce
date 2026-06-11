package com.cibermall.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_USUARIO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;

    @Column(name = "CORREO", length = 50, nullable = false, unique = true)
    private String correo;

    @Column(name = "CLAVE", length = 255, nullable = false)
    private String clave;

    @Column(name = "ESTADO")
    private Integer estado;

    @Column(name = "NOMBRES", length = 50, nullable = false)
    private String nombres;

    @Column(name = "APE_PATERNO", length = 50, nullable = false)
    private String apePaterno;

    @Column(name = "APE_MATERNO", length = 50, nullable = false)
    private String apeMaterno;

    @Column(name = "NRO_DOC", length = 15, nullable = false, unique = true)
    private String nroDoc;

    @Column(name = "TELEFONO", length = 9, nullable = false)
    private String telefono;

    @Column(name = "DIRECCION", length = 50)
    private String direccion;

    @Column(name = "ID_DISTRITO", nullable = false)
    private Integer idDistrito;

    @Column(name = "ULTIMO_ACCESO")
    private LocalDateTime ultimoAcceso;

    @Column(name = "FECHA_ACTUALIZACION")
    private LocalDateTime fechaActualizacion;

    @Column(name = "FECHA_REGISTRO")
    private LocalDateTime fechaRegistro;

    @Column(name = "ROL", length = 20, nullable = false)
    private String rol; 
}