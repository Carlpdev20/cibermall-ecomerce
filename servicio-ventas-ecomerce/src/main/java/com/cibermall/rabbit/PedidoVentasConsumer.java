package com.cibermall.rabbit;



import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.cibermall.dto.PedidoVentaDTO;
import com.cibermall.service.VentaService;

@Component
public class PedidoVentasConsumer {
	@Autowired 
    private VentaService ventaService;

    @RabbitListener(queues = "cola.ventas")
    public void recibirPedidoParaVenta(PedidoVentaDTO pedido) {
    	ventaService.crearVentasDesdePedido(pedido);
        System.out.println("Pedido recibido en ventas: " + pedido.getPedidoId());
 
    }
}
