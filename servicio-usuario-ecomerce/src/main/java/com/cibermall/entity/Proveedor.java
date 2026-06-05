package com.cibermall.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_PROVEEDOR")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROVEEDOR")
    private Integer idProveedor;

    @Column(name = "RUC", length = 11, nullable = false, unique = true)
    private String ruc;

    @Column(name = "RAZON_SOCIAL", length = 100, nullable = false)
    private String razonSocial;

    @Column(name = "TELEFONO", length = 15, nullable = false)
    private String telefono;

    @Column(name = "DIRECCION", length = 80, nullable = false)
    private String direccion;

    @Column(name = "ID_DISTRITO", nullable = false)
    private Integer idDistrito;

    @Column(name = "CORREO", length = 100)
    private String correo;

    @Column(name = "ESTADO")
    private Integer estado;

    @Column(name = "FECHA_REGISTRO", updatable = false)
    private LocalDateTime fechaRegistro;

    @PrePersist
    protected void onCreate() {
        this.fechaRegistro = LocalDateTime.now();
        if (this.estado == null) this.estado = 1;
    }
}