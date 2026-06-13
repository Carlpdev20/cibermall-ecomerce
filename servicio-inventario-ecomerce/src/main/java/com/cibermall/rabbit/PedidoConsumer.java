package com.cibermall.rabbit;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cibermall.dto.PedidoInventarioDTO;
import com.cibermall.service.InventarioService;

@Component
public class PedidoConsumer{
	@Autowired
    private  InventarioService service;

    
	@RabbitListener(queues = RabbitMQConfig.COLA_PEDIDOS)
    public void pedidoCreado(PedidoInventarioDTO pedido) {
		 service.descontarStockPorPedido(pedido);
    }
}