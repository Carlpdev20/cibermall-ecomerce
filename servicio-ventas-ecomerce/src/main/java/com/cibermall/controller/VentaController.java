package com.cibermall.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibermall.dto.VentaRequest;
import com.cibermall.dto.VentaResponse;
import com.cibermall.service.VentaService;

@RestController
@RequestMapping("/api/ventas")

public class VentaController {

    private final VentaService ventaService;
    
    

    public VentaController(VentaService ventaService) {
		super();
		this.ventaService = ventaService;
	}

	@PostMapping
    public ResponseEntity<VentaResponse> create(@RequestBody VentaRequest request) {
        return ResponseEntity.ok(ventaService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(ventaService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<VentaResponse>> findAll() {
        return ResponseEntity.ok(ventaService.findAll());
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<VentaResponse>> findByUsuarioId(@PathVariable Integer usuarioId) {
        return ResponseEntity.ok(ventaService.findByUsuarioId(usuarioId));
    }
}