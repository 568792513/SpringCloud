package org.hui.payment.controller;

import lombok.extern.slf4j.Slf4j;
import org.hui.entity.Payment;
import org.hui.entity.Result;
import org.hui.payment.config.IdGenerator;
import org.hui.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author zh
 * @Date 2021/2/1 11:09
 * description :
 */
@RestController
@RequestMapping("/api/payment")
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Resource
    private IdGenerator idGenerator;

    @Value("${server.port}")
    private Integer severPort;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    private Result<Integer> create(@RequestBody Payment payment) {
        log.info("调用服务端口：" + severPort);
        payment.setId(idGenerator.nextId(Payment.class));
        int result = paymentService.create(payment);
        log.info("插入结果：{}", result);
        if (result > 0) {
            return new Result<>(0, "成功, server port: " + severPort, result);
        } else {
            return new Result<>(1, "失败");
        }
    }

    @GetMapping("get/{id}")
    private Result<Payment> get(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new Result<>(0, "成功, server port: " + severPort, payment);
        } else {
            return new Result<>(1, "无对应记录");
        }
    }

    @GetMapping("info/ok/{id}")
    private Result<Payment> ok(@PathVariable("id") Long id) throws InterruptedException {
        // TimeUnit.SECONDS.sleep(10);
        return new Result<>(0, paymentService.paymentInfo_OK(id));
    }

    @GetMapping("info/timeout/{id}")
    private Result<Payment> timeout(@PathVariable("id") Long id) {
        return new Result<>(0, paymentService.paymentInfo_Timeout(id));
    }
}
