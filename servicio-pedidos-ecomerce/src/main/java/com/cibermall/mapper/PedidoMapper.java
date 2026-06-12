package com.cibermall.mapper;

import com.cibermall.dto.DetallePedidoInventarioDTO;
import com.cibermall.dto.DetallePedidoResponse;
import com.cibermall.dto.DetallePedidoVentaDTO;
import com.cibermall.dto.PedidoInventarioDTO;
import com.cibermall.dto.PedidoResponse;
import com.cibermall.dto.PedidoVentaDTO;
import com.cibermall.entity.DetallePedido;
import com.cibermall.entity.Pedido;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoMapper {

    public PedidoResponse toResponse(Pedido pedido) {
        PedidoResponse response = new PedidoResponse();
        response.setId(pedido.getId());
        response.setUsuarioId(pedido.getUsuarioId());
        response.setFechaPedido(pedido.getFechaPedido());
        response.setTotal(pedido.getTotal());
        response.setEstado(pedido.getEstado());

        List<DetallePedidoResponse> detalles = pedido.getDetalles()
                .stream()
                .map(this::toDetalleResponse)
                .toList();

        response.setDetalles(detalles);

        return response;
    }

    private DetallePedidoResponse toDetalleResponse(DetallePedido detalle) {
        DetallePedidoResponse response = new DetallePedidoResponse();
        response.setProductoId(detalle.getProductoId());
        response.setNombreProducto(detalle.getNombreProducto());
        response.setCantidad(detalle.getCantidad());
        response.setPrecioUnitario(detalle.getPrecioUnitario());
        response.setSubtotal(detalle.getSubtotal());
        return response;
    }
    public PedidoInventarioDTO toInventarioDTO(Pedido pedido) {
        PedidoInventarioDTO dto = new PedidoInventarioDTO();
        dto.setPedidoId(pedido.getId());

        List<DetallePedidoInventarioDTO> detalles = pedido.getDetalles()
                .stream()
                .map(this::toDetalleInventarioDTO)
                .toList();

        dto.setDetalles(detalles);

        return dto;
    }

    private DetallePedidoInventarioDTO toDetalleInventarioDTO(DetallePedido detalle) {
        DetallePedidoInventarioDTO dto = new DetallePedidoInventarioDTO();
        dto.setProductoId(detalle.getProductoId());
        dto.setCantidad(detalle.getCantidad());
        return dto;
    }
    
    public PedidoVentaDTO toVentaDTO(Pedido pedido) {
        PedidoVentaDTO dto = new PedidoVentaDTO();

        dto.setPedidoId(pedido.getId());
        dto.setUsuarioId(pedido.getUsuarioId());
        dto.setTotal(pedido.getTotal());

        List<DetallePedidoVentaDTO> detalles = pedido.getDetalles()
                .stream()
                .map(this::toDetalleVentaDTO)
                .toList();

        dto.setDetalles(detalles);

        return dto;
    }

    private DetallePedidoVentaDTO toDetalleVentaDTO(DetallePedido detalle) {
        DetallePedidoVentaDTO dto = new DetallePedidoVentaDTO();

        dto.setProductoId(detalle.getProductoId());
        dto.setNombreProducto(detalle.getNombreProducto());
        dto.setCantidad(detalle.getCantidad());
        dto.setPrecioUnitario(detalle.getPrecioUnitario());
        dto.setSubtotal(detalle.getSubtotal());

        return dto;
    }
    
    
}