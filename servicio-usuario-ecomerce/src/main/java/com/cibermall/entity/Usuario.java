package com.cibermall.entity;

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

    @Column(name = "NOMBRES", length = 50, nullable = false)
    private String nombres;

    @Column(name = "APE_PATERNO", length = 50, nullable = false)
    private String apePaterno;

    @Column(name = "APE_MATERNO", length = 50, nullable = false)
    private String apeMaterno;

    @Column(name = "CORREO", length = 50, nullable = false, unique = true)
    private String correo;

    @Column(name = "CLAVE", length = 255, nullable = false)
    private String clave;

    @Column(name = "NRO_DOC", length = 15, nullable = false, unique = true)
    private String nroDoc;

    @Column(name = "DIRECCION", length = 50)
    private String direccion;

    @Column(name = "TELEFONO", length = 9, nullable = false)
    private String telefono;

    // 👇 Nuevos campos de control y auditoría
    @Column(name = "ESTADO")
    private Integer estado;

    @Column(name = "ULTIMO_ACCESO")
    private LocalDateTime ultimoAcceso;

    @Column(name = "FECHA_ACTUALIZACION")
    private LocalDateTime fechaActualizacion;

    @Column(name = "FECHA_REGISTRO", updatable = false)
    private LocalDateTime fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DISTRITO", nullable = false)
    private Distrito distrito;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROL", nullable = false)
    private Rol rol;

    @PrePersist
    protected void onCreate() {
        this.fechaRegistro = LocalDateTime.now();
        if (this.estado == null) {
            this.estado = 1; // Activo por defecto al registrarse
        }
    }
    
    @PreUpdate
    protected void onUpdate() {
        this.fechaActualizacion = LocalDateTime.now();
    }
}