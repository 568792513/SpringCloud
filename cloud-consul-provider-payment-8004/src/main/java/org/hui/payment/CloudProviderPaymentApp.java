package org.hui.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author zh
 * @Date 2021/1/29 15:00
 * description :
 */
@SpringBootApplication
// @MapperScan("mapper")
@EnableDiscoveryClient
public class CloudProviderPaymentApp {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPaymentApp.class, args);
    }
}
