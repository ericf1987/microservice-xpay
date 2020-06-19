package az.xpay.xweb.amqp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static az.xpay.xweb.amqp.config.RabbitMqConfig.*;

/**
 * @author Eric F
 * @version 1.0
 * @date 2020/6/16 18:38
 */
@Component
@Slf4j
public class ReceiveAlarmQueue {

    @RabbitListener(
            containerFactory = "rabbitListenerContainerFactory",
            bindings = @QueueBinding(
                    value = @Queue(value = QUEUE_NAME, durable = "true"),
                    exchange = @Exchange(value = EXCHANGE_NAME, type = ExchangeTypes.TOPIC),
                    key = ROUTE_KEY
            ))
    public void receive(@Payload Object obj) {
        log.info("consume success ... {}", obj.toString());
    }


}
