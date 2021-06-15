package org.hui.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.hui.entity.Payment;
import org.hui.entity.Result;
import org.hui.service.PaymentFeignHystrixService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author zh
 * @Date 2021/6/2 10:53
 * description :
 */
@RestController
public class OrderFeignHystrixController {

    @Resource
    private PaymentFeignHystrixService paymentFeignHystrixService;

    @GetMapping("info/ok/{id}")
    private Result<Payment> ok(@PathVariable("id") Long id) {
        return paymentFeignHystrixService.ok(id);
    }

    @GetMapping("info/timeout/{id}")
    private Result<Payment> timeout(@PathVariable("id") Long id) {
        return paymentFeignHystrixService.timeout(id);
    }

}
