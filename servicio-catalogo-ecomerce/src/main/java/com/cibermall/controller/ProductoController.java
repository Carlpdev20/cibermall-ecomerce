package com.cibermall.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibermall.dto.ProductRequest;
import com.cibermall.dto.ProductResponse;
import com.cibermall.service.ProductService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	
   private final ProductService productService;
   
   public ProductoController( ProductService productService) {
	   this.productService = productService;
   }
    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest request) {
        ProductResponse response = productService.create(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Integer id) {
        ProductResponse response = productService.findById(id);
        return ResponseEntity.ok(response);
    }
	
}
