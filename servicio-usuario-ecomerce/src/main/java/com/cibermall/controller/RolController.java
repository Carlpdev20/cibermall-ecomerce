package com.cibermall.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibermall.entity.Rol;
import com.cibermall.repository.RolRepository;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    private final RolRepository rolRepository;
    
    
    public RolController(RolRepository rolRepository) {
		this.rolRepository = rolRepository;
	}

	@PostMapping
    public ResponseEntity<Rol> create(@RequestBody Rol rol) {
        return ResponseEntity.ok(rolRepository.save(rol));
    }

    @GetMapping
    public ResponseEntity<List<Rol>> findAll() {
        return ResponseEntity.ok(rolRepository.findAll());
    }
}
