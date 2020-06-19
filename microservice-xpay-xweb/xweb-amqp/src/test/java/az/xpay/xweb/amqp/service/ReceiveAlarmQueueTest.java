package az.xpay.xweb.amqp.service;

import az.xpay.XwebAmqpBaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Eric F
 * @version 1.0
 * @date 2020/6/16 19:03
 */
class ReceiveAlarmQueueTest extends XwebAmqpBaseTest {

    @Autowired
    ReceiveAlarmQueue receiveAlarmQueue;

    @Autowired
    SendAlarmQueue sendAlarmQueue;

    @Test
    void receive() {

        String src = "Hello Rabbit mq";
        sendAlarmQueue.send(src);
        receiveAlarmQueue.receive(src);

    }
}