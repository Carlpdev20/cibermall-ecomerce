package com.cibermall.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibermall.dto.InventarioRequest;
import com.cibermall.dto.InventarioResponse;
import com.cibermall.service.InventarioService;

@RestController
@RequestMapping("/api/inventario")

public class InventarioController {

    private final InventarioService inventarioService;
    
    
    public InventarioController(InventarioService inventarioService) {
		super();
		this.inventarioService = inventarioService;
	}

	@PostMapping
    public ResponseEntity<InventarioResponse> create(@RequestBody InventarioRequest request) {
        return ResponseEntity.ok(inventarioService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<InventarioResponse>> findAll() {
        return ResponseEntity.ok(inventarioService.findAll());
    }

    @GetMapping("/producto/{productoId}")
    public ResponseEntity<InventarioResponse> findByProductoId(@PathVariable Integer productoId) {
        return ResponseEntity.ok(inventarioService.findByProductoId(productoId));
    }

    @PutMapping("/aumentar/{productoId}/{cantidad}")
    public ResponseEntity<InventarioResponse> aumentarStock(
            @PathVariable Integer productoId,
            @PathVariable Integer cantidad
    ) {
        return ResponseEntity.ok(inventarioService.aumentarStock(productoId, cantidad));
    }

    @PutMapping("/disminuir/{productoId}/{cantidad}")
    public ResponseEntity<InventarioResponse> disminuirStock(
            @PathVariable Integer productoId,
            @PathVariable Integer cantidad
    ) {
        return ResponseEntity.ok(inventarioService.disminuirStock(productoId, cantidad));
    }
}
