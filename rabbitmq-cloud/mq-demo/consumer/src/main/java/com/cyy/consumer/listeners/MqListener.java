package com.cyy.consumer.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MqListener {
    @RabbitListener(queues = "simple.queue")
    public void getMqMessage(String msg){//String取决于发送的类型
        System.out.println("消费者收到了消息：【"+msg+"】");
    }

    @RabbitListener(queues = "work.queue")
    public void getWorkMessage1(String msg){//String取决于发送的类型
        System.out.println("消费者1收到了work消息：【"+msg+"】");
    }

    @RabbitListener(queues = "work.queue")
    public void getWorkMessage2(String msg){//String取决于发送的类型
        System.out.println("消费者2收到了work消息：【"+msg+"】");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name="xxx.queue"),
            exchange = @Exchange(name = "xxx.xxx",type= ExchangeTypes.DIRECT),
            key={"1","2"}
    ))
    public void getWorkMessage3(String msg){//String取决于发送的类型
        System.out.println("消费者2收到了work消息：【"+msg+"】");
    }
}
