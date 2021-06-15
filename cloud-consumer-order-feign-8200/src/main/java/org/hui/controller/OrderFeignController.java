package org.hui.controller;

import org.hui.entity.Payment;
import org.hui.entity.Result;
import org.hui.service.PaymentFeignService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

/**
 * @Author zh
 * @Date 2021/6/2 10:53
 * description :
 */
@Controller
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("get/{id}")
    private Result<Payment> get(@PathVariable("id") Long id) {
        return paymentFeignService.get(id);
    }

}
