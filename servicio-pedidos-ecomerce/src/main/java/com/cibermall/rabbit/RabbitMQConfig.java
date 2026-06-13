package com.cibermall.rabbit;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String EXCHANGE_PEDIDOS = "pedido.exchange";
	
	public static final String COLA_VENTAS = "cola.ventas";
	public static final String ROUTING_KEY_PEDIDO_VENTA = "pedido.venta";
	

    public static final String COLA_PEDIDOS = "cola.pedidos";
    public static final String ROUTING_KEY_PEDIDO_CREADO = "pedido.creado";
    
    
    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
    return new Jackson2JsonMessageConverter();
    }
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
    RabbitTemplate template = new RabbitTemplate(connectionFactory);
    template.setMessageConverter(jsonMessageConverter());
    return template;
    }
    
    @Bean
    public DirectExchange pedidoExchange() {
        return new DirectExchange(EXCHANGE_PEDIDOS);
    }

    @Bean
    public Queue colaPedidos() {
        return new Queue(COLA_PEDIDOS, true);
    }

    @Bean
    public Binding bindingPedidos() {
        return BindingBuilder
                .bind(colaPedidos())
                .to(pedidoExchange())
                .with(ROUTING_KEY_PEDIDO_CREADO);
    }
    
    @Bean
    public Queue colaVentas() {
        return new Queue(COLA_VENTAS, true);
    }

    @Bean
    public Binding bindingVentas() {
        return BindingBuilder
                .bind(colaVentas())
                .to(pedidoExchange())
                .with(ROUTING_KEY_PEDIDO_VENTA);
    }
    
}