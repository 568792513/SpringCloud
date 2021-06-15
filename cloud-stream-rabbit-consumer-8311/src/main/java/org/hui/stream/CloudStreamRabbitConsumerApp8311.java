package org.hui.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author zh
 * @Date 2021/6/11 11:44
 * description :
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudStreamRabbitConsumerApp8311 {
    public static void main(String[] args) {
        SpringApplication.run(CloudStreamRabbitConsumerApp8311.class, args);
    }
}
