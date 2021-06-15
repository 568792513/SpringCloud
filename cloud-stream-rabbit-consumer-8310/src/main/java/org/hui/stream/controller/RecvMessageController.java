package org.hui.stream.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * @Author zh
 * @Date 2021/6/11 11:46
 * description :
 */
@EnableBinding(Sink.class)
@Slf4j
public class RecvMessageController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("消费者" + serverPort + "收到消息：" + message.getPayload());
    }
}
