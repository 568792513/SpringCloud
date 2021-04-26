package org.hui.order.controller;

import org.hui.entity.Payment;
import org.hui.entity.Result;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author zh
 * @Date 2021/4/22 15:45
 * description :
 */
@RestController
@RequestMapping("/api/order/zk")
public class OrderZKController {

    private static final String url = "http://provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/get/{id}")
    public String getInfo(@PathVariable Long id) {
        String payment = restTemplate.getForObject(url + "/api/payment/get/" + id, String.class);
        return payment;
    }
}
