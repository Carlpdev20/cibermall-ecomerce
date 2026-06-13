package com.cibermall.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibermall.entity.Distrito;
import com.cibermall.repository.DistritoRepository;

@RestController
@RequestMapping("/api/distritos")
public class DistritoController {

    private final DistritoRepository distritoRepository;

    public DistritoController(DistritoRepository distritoRepository) {
    	this.distritoRepository = distritoRepository;
    }
    @PostMapping
    public ResponseEntity<Distrito> create(@RequestBody Distrito distrito) {
        return ResponseEntity.ok(distritoRepository.save(distrito));
    }

    @GetMapping
    public ResponseEntity<List<Distrito>> findAll() {
        return ResponseEntity.ok(distritoRepository.findAll());
    }
}
