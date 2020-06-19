package az.xpay.xweb.amqp.service;

import az.xpay.xweb.amqp.config.RabbitMqConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author Eric F
 * @version 1.0
 * @date 2020/6/16 18:36
 */
@Component
@Slf4j
public class SendAlarmQueue {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void send(Object obj) {
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NAME, RabbitMqConfig.ROUTE_KEY, obj, new CorrelationData(UUID.randomUUID().toString()));
    }


}
