package com.cibermall.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cibermall.dto.DetallePedidoRequest;
import com.cibermall.dto.PedidoRequest;
import com.cibermall.dto.PedidoResponse;
import com.cibermall.dto.ProductoResponse;
import com.cibermall.entity.DetallePedido;
import com.cibermall.entity.Pedido;
import com.cibermall.feign.CatalogoFeignClient;
import com.cibermall.mapper.PedidoMapper;
import com.cibermall.rabbit.PedidoProducer;
import com.cibermall.repository.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
    private  PedidoRepository pedidoRepository;
	@Autowired
    private  CatalogoFeignClient catalogoFeignClient;
	@Autowired
    private  PedidoMapper pedidoMapper;
	@Autowired
    private  PedidoProducer pedidoProducer;

    public PedidoService(
            PedidoRepository pedidoRepository,
            CatalogoFeignClient catalogoFeignClient,
            PedidoMapper pedidoMapper,
            PedidoProducer pedidoProducer
    ) {
        this.pedidoRepository = pedidoRepository;
        this.catalogoFeignClient = catalogoFeignClient;
        this.pedidoMapper = pedidoMapper;
        this.pedidoProducer = pedidoProducer;
    }

    public PedidoResponse crearPedido(PedidoRequest request) {

        Pedido pedido = new Pedido();
        pedido.setUsuarioId(request.getUsuarioId());
        pedido.setEstado("PENDIENTE");

        List<DetallePedido> detalles = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;

        for (DetallePedidoRequest item : request.getDetalles()) {

            ProductoResponse producto = catalogoFeignClient.obtenerProductoPorId(item.getProductoId());

            if (producto == null || !Boolean.TRUE.equals(producto.getEstado())) {
                throw new RuntimeException("Producto no disponible: ID " + item.getProductoId());
            }

            BigDecimal subtotal = producto.getPrecio()
                    .multiply(BigDecimal.valueOf(item.getCantidad()));

            DetallePedido detalle = new DetallePedido();
            detalle.setPedido(pedido);
            detalle.setProductoId(producto.getId());
            detalle.setNombreProducto(producto.getNombre());
            detalle.setPrecioUnitario(producto.getPrecio());
            detalle.setCantidad(item.getCantidad());
            detalle.setSubtotal(subtotal);

            detalles.add(detalle);
            total = total.add(subtotal);
        }

        pedido.setTotal(total);
        pedido.setDetalles(detalles);

        Pedido guardado = pedidoRepository.save(pedido);

        pedidoProducer.enviarPedidoCreado(pedidoMapper.toInventarioDTO(guardado));
        pedidoProducer.enviarPedidoAVentas(pedidoMapper.toVentaDTO(guardado));

        return pedidoMapper.toResponse(guardado);

       
    }

    public PedidoResponse obtenerPorId(Integer id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado: ID " + id));

        return pedidoMapper.toResponse(pedido);
    }

    public List<PedidoResponse> obtenerPorCliente(Integer usuarioId) {
        return pedidoRepository.findByUsuarioId(usuarioId)
                .stream()
                .map(pedidoMapper::toResponse)
                .collect(Collectors.toList());
    }
}