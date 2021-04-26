package org.hui.controller;

import lombok.extern.slf4j.Slf4j;
import org.hui.entity.Payment;
import org.hui.entity.Result;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/create")
    public Result create(@RequestBody Payment payment) {
        return restTemplate.postForObject(url + "/api/payment/create", payment, Result.class);
    }

    @GetMapping("/get/{id}")
    public Result get(@PathVariable("id") Long id) {
        return restTemplate.getForObject("http://provider-payment/api/payment/get/1", Result.class);
    }

    @GetMapping("discovery")
    private DiscoveryClient getDiscoveryInfo() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service:" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("provider-payment");
        for (ServiceInstance instance : instances) {
            log.info(instance.toString());
        }
        return this.discoveryClient;
    }
}
