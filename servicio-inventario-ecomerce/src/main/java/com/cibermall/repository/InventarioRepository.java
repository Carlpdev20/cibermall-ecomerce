package com.cibermall.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibermall.entity.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario, Integer> {

    Optional<Inventario> findByProductoId(Integer productoId);

    boolean existsByProductoId(Integer productoId);
}
