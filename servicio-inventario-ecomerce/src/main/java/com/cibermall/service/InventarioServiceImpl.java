package com.cibermall.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibermall.dto.InventarioRequest;
import com.cibermall.dto.InventarioResponse;
import com.cibermall.entity.Inventario;
import com.cibermall.mapper.InventarioMapper;
import com.cibermall.repository.InventarioRepository;


@Service
public class InventarioServiceImpl implements InventarioService {

    private final com.cibermall.repository.InventarioRepository inventarioRepository;
    private final InventarioMapper inventarioMapper;
    
    
    
    public InventarioServiceImpl(InventarioRepository inventarioRepository, InventarioMapper inventarioMapper) {
		super();
		this.inventarioRepository = inventarioRepository;
		this.inventarioMapper = inventarioMapper;
	}

	@Override
    public InventarioResponse create(InventarioRequest request) {

        if (inventarioRepository.existsByProductoId(request.getProductoId())) {
            throw new RuntimeException("El producto ya tiene inventario registrado");
        }

        Inventario inventario = inventarioMapper.toInventario(request);

        Inventario guardado = inventarioRepository.save(inventario);

        return inventarioMapper.toResponse(guardado);
    }

    @Override
    public InventarioResponse findByProductoId(Integer productoId) {

        Inventario inventario = inventarioRepository.findByProductoId(productoId)
                .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));

        return inventarioMapper.toResponse(inventario);
    }

    @Override
    public List<InventarioResponse> findAll() {
        return inventarioRepository.findAll()
                .stream()
                .map(inventarioMapper::toResponse)
                .toList();
    }

    @Override
    public InventarioResponse aumentarStock(Integer productoId, Integer cantidad) {

        Inventario inventario = inventarioRepository.findByProductoId(productoId)
                .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));

        inventario.setStock(inventario.getStock() + cantidad);

        return inventarioMapper.toResponse(inventarioRepository.save(inventario));
    }

    @Override
    public InventarioResponse disminuirStock(Integer productoId, Integer cantidad) {

        Inventario inventario = inventarioRepository.findByProductoId(productoId)
                .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));

        Integer stockDisponible = inventario.getStock() - inventario.getStockReservado();

        if (stockDisponible < cantidad) {
            throw new RuntimeException("Stock insuficiente");
        }

        inventario.setStock(inventario.getStock() - cantidad);

        return inventarioMapper.toResponse(inventarioRepository.save(inventario));
    }
}
