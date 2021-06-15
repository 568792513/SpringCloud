package org.hui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author zh
 * @Date 2021/6/2 10:44
 * description :
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CloudConsumerOrderFeignApp {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrderFeignApp.class, args);
    }
}
