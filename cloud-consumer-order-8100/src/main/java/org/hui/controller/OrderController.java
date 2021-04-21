package org.hui.controller;

import lombok.extern.slf4j.Slf4j;
import org.hui.entity.Payment;
import org.hui.entity.Result;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author zh
 * @Date 2021/4/21 9:49
 * description :
 */
@RestController
@RequestMapping("/api/consumer")
@Slf4j
public class OrderController {

    private static final String url = "http://provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/create")
    public Result create(@RequestBody Payment payment) {
        return restTemplate.postForObject(url + "/api/payment/create", payment, Result.class);
    }

    @GetMapping("/get/{id}")
    public Result get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(url + "/api/payment/get/" + id, Result.class);
    }
}
