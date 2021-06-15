package org.hui.stream.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * @Author zh
 * @Date 2021/6/11 10:44
 * description :
 */
@EnableBinding(Source.class)
@Slf4j
public class IMessageServiceImpl implements IMessageService{

    @Resource
    private MessageChannel output;

    @Override
    public String send(String message) {
        Message message1 = MessageBuilder.withPayload(message).build();
        boolean result = output.send(message1);
        Assert.isTrue(result, "消息发送失败");
        log.info("消息发送完成：" + message);
        return "消息发送完成";
    }
}
