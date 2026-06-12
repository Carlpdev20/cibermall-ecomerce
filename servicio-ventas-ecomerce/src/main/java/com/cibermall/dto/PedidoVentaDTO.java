package com.cibermall.dto;

import java.util.List;

public class PedidoVentaDTO {

    private Integer pedidoId;
    private Integer usuarioId;
    private java.math.BigDecimal total;
    private List<DetallePedidoVentaDTO> detalles;

    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public java.math.BigDecimal getTotal() {
        return total;
    }

    public void setTotal(java.math.BigDecimal total) {
        this.total = total;
    }

    public List<DetallePedidoVentaDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedidoVentaDTO> detalles) {
        this.detalles = detalles;
    }
}