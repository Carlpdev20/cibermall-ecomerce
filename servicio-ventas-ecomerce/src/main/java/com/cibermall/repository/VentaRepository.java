package com.cibermall.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibermall.entity.Venta;

public interface VentaRepository extends JpaRepository<Venta, Integer> {

    List<Venta> findByUsuarioId(Integer usuarioId);
}
