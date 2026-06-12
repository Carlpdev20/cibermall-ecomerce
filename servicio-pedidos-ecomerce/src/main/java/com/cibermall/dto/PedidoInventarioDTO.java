package com.cibermall.dto;

import java.util.List;

public class PedidoInventarioDTO {

    private Integer pedidoId;
    private List<DetallePedidoInventarioDTO> detalles;

    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }

    public List<DetallePedidoInventarioDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedidoInventarioDTO> detalles) {
        this.detalles = detalles;
    }
}