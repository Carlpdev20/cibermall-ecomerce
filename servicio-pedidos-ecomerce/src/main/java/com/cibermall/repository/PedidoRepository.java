package com.cibermall.repository;

import com.cibermall.entity.Pedido;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByUsuarioId(Integer usuarioId);
}