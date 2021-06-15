package org.hui.service;

import org.hui.entity.Payment;
import org.hui.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author zh
 * @Date 2021/6/2 10:48
 * description :
 */
@Service
@FeignClient(value = "provider-payment")
public interface PaymentFeignService {

    @GetMapping("get/{id}")
    public Result<Payment> get(@PathVariable("id") Long id);
}
