package com.cibermall.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.cibermall.dto.InventarioRequest;
import com.cibermall.dto.InventarioResponse;
import com.cibermall.entity.Inventario;

@Component
public class InventarioMapper {

    public Inventario toInventario(InventarioRequest request) {
        Inventario inventario = new Inventario();

        inventario.setProductoId(request.getProductoId());
        inventario.setStock(request.getStock());
        inventario.setStockReservado(0);
        inventario.setEstado(true);
        inventario.setFechaRegistro(LocalDateTime.now());

        return inventario;
    }

    public InventarioResponse toResponse(Inventario inventario) {
        InventarioResponse response = new InventarioResponse();

        response.setId(inventario.getId());
        response.setProductoId(inventario.getProductoId());
        response.setStock(inventario.getStock());
        response.setStockReservado(inventario.getStockReservado());
        response.setStockDisponible(
                inventario.getStock() - inventario.getStockReservado()
        );
        response.setEstado(inventario.getEstado());
        response.setFechaRegistro(inventario.getFechaRegistro());

        return response;
    }
}
