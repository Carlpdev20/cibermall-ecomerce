package com.cibermall.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PedidoResponse {

    private Integer id;
    private Integer usuarioId;
    private LocalDateTime fechaPedido;
    private BigDecimal total;
    private String estado;
    private List<DetallePedidoResponse> detalles;

    public Integer getId() {
        return id;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public String getEstado() {
        return estado;
    }

    public List<DetallePedidoResponse> getDetalles() {
        return detalles;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setFechaPedido(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setDetalles(List<DetallePedidoResponse> detalles) {
        this.detalles = detalles;
    }
}