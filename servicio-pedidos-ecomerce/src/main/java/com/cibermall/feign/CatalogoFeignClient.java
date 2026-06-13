package com.cibermall.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cibermall.dto.ProductoResponse;

@FeignClient(name = "servicio-catalogo-ecomerce")
public interface CatalogoFeignClient {

    @GetMapping("/api/productos/{id}")
    ProductoResponse obtenerProductoPorId(@PathVariable("id") Integer id);
}