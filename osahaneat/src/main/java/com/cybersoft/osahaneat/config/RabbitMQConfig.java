package com.cybersoft.osahaneat.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Value("${rabbitmq.queue}")
    private String queuename;

    @Value("${rabbitmq.exchange}")
    private String exchangename;

    @Value("${rabbitmq.routingKey}")
    private String routingKey;

    // Tao queue tren he thong rabbitmq
    @Bean
    public Queue queue() {
        return new Queue(queuename);
    }

    // Tao exchange tren he thong rabbitmq
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(exchangename);
    }

    // Tao binding(routing key) de lien ket queue voi exchange
    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(topicExchange())
                .with(routingKey);
    }

}
