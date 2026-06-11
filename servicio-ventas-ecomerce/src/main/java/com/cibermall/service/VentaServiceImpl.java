package com.cibermall.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibermall.dto.VentaRequest;
import com.cibermall.dto.VentaResponse;
import com.cibermall.entity.Venta;
import com.cibermall.mapper.VentaMapper;
import com.cibermall.repository.VentaRepository;

@Service

public class VentaServiceImpl implements VentaService {

    private final VentaRepository ventaRepository;
    private final VentaMapper ventaMapper;
    
    
    public VentaServiceImpl(VentaRepository ventaRepository, VentaMapper ventaMapper) {
		super();
		this.ventaRepository = ventaRepository;
		this.ventaMapper = ventaMapper;
	}

	@Override
    public VentaResponse create(VentaRequest request) {

        Venta venta = ventaMapper.toVenta(request);

        Venta ventaGuardada = ventaRepository.save(venta);

        return ventaMapper.toResponse(ventaGuardada);
    }

    @Override
    public VentaResponse findById(Integer id) {

        Venta venta = ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        return ventaMapper.toResponse(venta);
    }

    @Override
    public List<VentaResponse> findAll() {

        return ventaRepository.findAll()
                .stream()
                .map(ventaMapper::toResponse)
                .toList();
    }

    @Override
    public List<VentaResponse> findByUsuarioId(Integer usuarioId) {

        return ventaRepository.findByUsuarioId(usuarioId)
                .stream()
                .map(ventaMapper::toResponse)
                .toList();
    }
}
