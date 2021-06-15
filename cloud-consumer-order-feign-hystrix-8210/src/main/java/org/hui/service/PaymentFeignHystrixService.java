package org.hui.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.hui.entity.Payment;
import org.hui.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author zh
 * @Date 2021/6/2 10:48
 * description :
 */
@Service
@FeignClient(value = "PROVIDER-PAYMENT-HYSTRIX", path = "/api/payment", fallback = PaymentFeignHystrixServiceFallback.class)
public interface PaymentFeignHystrixService {

    @GetMapping("/info/ok/{id}")
    Result<Payment> ok(@PathVariable("id") Long id);

    @GetMapping("/info/timeout/{id}")
    Result<Payment> timeout(@PathVariable("id") Long id);
}
