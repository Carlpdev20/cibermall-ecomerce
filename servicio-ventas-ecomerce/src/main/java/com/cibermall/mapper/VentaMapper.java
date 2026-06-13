package com.cibermall.mapper;


import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cibermall.dto.DetalleVentaResponse;
import com.cibermall.dto.PedidoVentaDTO;
import com.cibermall.dto.VentaRequest;
import com.cibermall.dto.VentaResponse;
import com.cibermall.entity.DetalleVenta;
import com.cibermall.entity.Venta;

@Component
public class VentaMapper {

    public Venta toVenta(VentaRequest request) {
        Venta venta = new Venta();

        venta.setUsuarioId(request.getUsuarioId());
        venta.setEstado("REGISTRADA");
        venta.setFechaRegistro(LocalDateTime.now());

        List<DetalleVenta> detalles = request.getDetalles()
                .stream()
                .map(detalleRequest -> {
                    DetalleVenta detalle = new DetalleVenta();

                    detalle.setProductoId(detalleRequest.getProductoId());
                    detalle.setCantidad(detalleRequest.getCantidad());
                    detalle.setPrecioUnitario(detalleRequest.getPrecioUnitario());

                    BigDecimal subtotal = detalleRequest.getPrecioUnitario()
                            .multiply(BigDecimal.valueOf(detalleRequest.getCantidad()));

                    detalle.setSubtotal(subtotal);
                    detalle.setVenta(venta);

                    return detalle;
                })
                .toList();

        BigDecimal total = detalles.stream()
                .map(detalle -> detalle.getSubtotal())
                .reduce(BigDecimal.ZERO, (a, b) -> a.add(b));

      

        venta.setTotal(total);
        venta.setDetalles(detalles);

        return venta;
    }

    public VentaResponse toResponse(Venta venta) {
        VentaResponse response = new VentaResponse();

        response.setId(venta.getId());
        response.setUsuarioId(venta.getUsuarioId());
        response.setTotal(venta.getTotal());
        response.setEstado(venta.getEstado());
        response.setFechaRegistro(venta.getFechaRegistro());

        List<DetalleVentaResponse> detalles = venta.getDetalles()
                .stream()
                .map(detalle -> {
                    DetalleVentaResponse detalleResponse = new DetalleVentaResponse();

                    detalleResponse.setId(detalle.getId());
                    detalleResponse.setProductoId(detalle.getProductoId());
                    detalleResponse.setCantidad(detalle.getCantidad());
                    detalleResponse.setPrecioUnitario(detalle.getPrecioUnitario());
                    detalleResponse.setSubtotal(detalle.getSubtotal());

                    return detalleResponse;
                })
                .toList();

        response.setDetalles(detalles);

        return response;
    }
    public Venta toVentaDesdePedido(PedidoVentaDTO pedido) {
        Venta venta = new Venta();

//        venta.setId(pedido.getPedidoId());
        venta.setUsuarioId(pedido.getUsuarioId());
        venta.setEstado("GENERADA");
        venta.setFechaRegistro(LocalDateTime.now());
        venta.setTotal(pedido.getTotal());

        List<DetalleVenta> detalles = pedido.getDetalles()
                .stream()
                .map(detallePedido -> {
                    DetalleVenta detalleVenta = new DetalleVenta();

                    detalleVenta.setVenta(venta);
                    detalleVenta.setProductoId(detallePedido.getProductoId());
                    detalleVenta.setCantidad(detallePedido.getCantidad());
                    detalleVenta.setPrecioUnitario(detallePedido.getPrecioUnitario());
                    detalleVenta.setSubtotal(detallePedido.getSubtotal());

                    return detalleVenta;
                })
                .toList();

        venta.setDetalles(detalles);

        return venta;
    }
}
