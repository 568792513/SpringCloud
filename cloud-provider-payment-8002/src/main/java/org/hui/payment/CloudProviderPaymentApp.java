package org.hui.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author zh
 * @Date 2021/1/29 15:00
 * description :
 */
@SpringBootApplication
// @MapperScan("mapper")
@EnableEurekaClient
public class CloudProviderPaymentApp {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPaymentApp.class, args);
    }
}
