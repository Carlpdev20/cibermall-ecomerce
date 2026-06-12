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
    public static final String COLA_PEDIDOS = "pedido.creado.cola";
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
    public Queue pedidoCreadoCola() {
        return new Queue(COLA_PEDIDOS, true);
    }

    @Bean
    public Binding pedidoBinding() {
        return BindingBuilder
                .bind(pedidoCreadoCola())
                .to(pedidoExchange())
                .with(ROUTING_KEY_PEDIDO_CREADO);
    }
}