package com.cibermall.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_VENTA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VENTA")
    private Integer idVenta;

    @Column(name = "ID_USUARIO", nullable = false)
    private Integer idUsuario;

    @Column(name = "FECHA", updatable = false)
    private LocalDateTime fecha;

    @Column(name = "TOTAL", precision = 11, scale = 2, nullable = false)
    private BigDecimal total;

    @Column(name = "ESTADO", length = 1, nullable = false)
    private String estado;

    @Column(name = "TIPO_VENTA", length = 1)
    private String tipoVenta;

    @Column(name = "TIPO_PAGO", nullable = false)
    private Integer tipoPago;

    @Column(name = "NRO_OPERACION", length = 50)
    private String nroOperacion;

    @Column(name = "DIRECCION_ENVIO", length = 200)
    private String direccionEnvio;

    @Column(name = "ID_DISTRITO")
    private Integer idDistrito;

    @Column(name = "IMPORTE_PRODUCTOS", precision = 10, scale = 2)
    private BigDecimal importeProductos;

    @Column(name = "IMPORTE_ENVIO", precision = 10, scale = 2)
    private BigDecimal importeEnvio;

    @Column(name = "IMPORTE_NETO", precision = 10, scale = 2)
    private BigDecimal importeNeto;

    @Column(name = "IMPORTE_IGV", precision = 10, scale = 2)
    private BigDecimal importeIgv;

    @PrePersist
    protected void onCreate() {
        this.fecha = LocalDateTime.now();
        if (this.tipoVenta == null) this.tipoVenta = "P";
        if (this.tipoPago == null) this.tipoPago = 1;
        if (this.importeProductos == null) this.importeProductos = BigDecimal.ZERO;
        if (this.importeEnvio == null) this.importeEnvio = BigDecimal.ZERO;
        if (this.importeNeto == null) this.importeNeto = BigDecimal.ZERO;
        if (this.importeIgv == null) this.importeIgv = BigDecimal.ZERO;
    }
}