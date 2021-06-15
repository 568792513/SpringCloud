package org.hui.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @Author zh
 * @Date 2021/1/29 15:00
 * description :
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class CloudProviderPaymentHystrixApp {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPaymentHystrixApp.class, args);
    }
}
