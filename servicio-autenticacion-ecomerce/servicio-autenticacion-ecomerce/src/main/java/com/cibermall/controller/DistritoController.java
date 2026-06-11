package com.cibermall.controller;

import com.cibermall.DTO.DistritoDTO;
import com.cibermall.service.DistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class DistritoController {

    @Autowired
    private DistritoService distritoService;

    // GET http://localhost:8084/auth/distritos  — público, sin token
    @GetMapping("/distritos")
    public ResponseEntity<List<DistritoDTO>> listarDistritos() {
        return ResponseEntity.ok(distritoService.listarTodos());
    }
}
