package com.cibermall.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_DETALLE_VENTA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DETALLE_VENTA")
    private Integer idDetalleVenta;

    @Column(name = "ID_PRODUCTO", nullable = false)
    private Integer idProducto;

    @Column(name = "CANTIDAD", nullable = false)
    private Short cantidad;

    @Column(name = "SUB_TOTAL", precision = 10, scale = 2, nullable = false)
    private BigDecimal subTotal;

    @Column(name = "PRECIO_VENTA", precision = 10, scale = 2, nullable = false)
    private BigDecimal precioVenta;

    @Column(name = "DESCUENTO", precision = 10, scale = 2)
    private BigDecimal descuento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_VENTA", nullable = false)
    private Venta venta;

    @PrePersist
    protected void onCreate() {
        if (this.descuento == null) this.descuento = BigDecimal.ZERO;
    }
}