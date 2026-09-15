package com.cyy.publisher.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class CommonConfig implements ApplicationContextAware {//当容器初始化完成，就可以传给该类使用
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //获取RbbitTemplate
        RabbitTemplate rabbitTemplate = applicationContext.getBean(RabbitTemplate.class);
        //设置ReturnCallback
        rabbitTemplate.setReturnsCallback(returned -> {
            log.info("ReturnCallback: message={}, replyCode={}, replyText={}, exchange={}, routingKey={}",
                    returned.getMessage().toString(),
                    returned.getReplyCode(),
                    returned.getReplyText(),
                    returned.getExchange(),
                    returned.getRoutingKey());
        });
    }
}
