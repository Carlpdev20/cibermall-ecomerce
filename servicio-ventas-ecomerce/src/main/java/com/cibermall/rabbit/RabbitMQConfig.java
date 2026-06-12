package com.cibermall.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
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
        return new DirectExchange(EXCHANGE_PEDIDOS, true, false);
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