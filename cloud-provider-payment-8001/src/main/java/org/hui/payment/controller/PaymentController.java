package org.hui.payment.controller;

import lombok.extern.slf4j.Slf4j;
import org.hui.payment.entity.Payment;
import org.hui.payment.entity.Result;
import org.hui.payment.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

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

    @RequestMapping(value = "create", method = RequestMethod.POST)
    private Result<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果：{}", result);
        if (result > 0) {
            return new Result<>(0, "成功", result);
        } else {
            return new Result<>(1, "失败");
        }
    }

    @GetMapping("get/{id}")
    private Result<Payment> get(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new Result<>(0, "成功", payment);
        } else {
            return new Result<>(1, "无对应记录");
        }
    }
}
