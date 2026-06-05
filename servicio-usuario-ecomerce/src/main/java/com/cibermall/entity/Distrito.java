package com.cibermall.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_DISTRITO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Distrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DISTRITO")
    private Integer idDistrito;

    @Column(name = "NOMBRE", length = 50, nullable = false)
    private String nombre;

    @Column(name = "COSTO_ENVIO", precision = 8, scale = 2)
    private BigDecimal costoEnvio;
}