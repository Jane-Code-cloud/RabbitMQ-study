package com.cyy.mq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("xxx.fanout");
    }
    @Bean
    public Queue fanoutQueue(){
        return new Queue("xxx.queue");
    }

    public Binding bindingQueue(Queue fanoutQueue, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueue).to(fanoutExchange);
    }
}
