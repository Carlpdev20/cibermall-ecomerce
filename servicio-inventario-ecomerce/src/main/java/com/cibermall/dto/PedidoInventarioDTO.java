package com.cibermall.dto;

import java.util.List;

public class PedidoInventarioDTO {

    private Integer pedidoId;
    private List<DetalleInventarioDTO> detalles;

    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }

    public List<DetalleInventarioDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleInventarioDTO> detalles) {
        this.detalles = detalles;
    }
}