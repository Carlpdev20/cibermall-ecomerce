package com.cibermall.service;

import java.util.List;

import com.cibermall.dto.InventarioRequest;
import com.cibermall.dto.InventarioResponse;
import com.cibermall.dto.PedidoInventarioDTO;

public interface InventarioService {

    InventarioResponse create(InventarioRequest request);

    InventarioResponse findByProductoId(Integer productoId);

    List<InventarioResponse> findAll();

    InventarioResponse aumentarStock(Integer productoId, Integer cantidad);

    InventarioResponse disminuirStock(Integer productoId, Integer cantidad);
    
    void descontarStockPorPedido(PedidoInventarioDTO dto);
}
