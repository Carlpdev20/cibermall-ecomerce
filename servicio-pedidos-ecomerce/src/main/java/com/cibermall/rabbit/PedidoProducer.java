package com.cibermall.rabbit;


import com.cibermall.dto.PedidoInventarioDTO;
import com.cibermall.dto.PedidoVentaDTO;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoProducer {
	@Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviarPedidoCreado(PedidoInventarioDTO pedido) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_PEDIDOS,
                RabbitMQConfig.ROUTING_KEY_PEDIDO_CREADO,
                pedido
        );
        System.out.println("Objeto: " + pedido + "enviado a RabbitMQ");
    }
    
    public void enviarPedidoAVentas(PedidoVentaDTO pedido) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_PEDIDOS,
                RabbitMQConfig.ROUTING_KEY_PEDIDO_VENTA,
                pedido
        );
    }
}