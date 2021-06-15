package org.hui.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author zh
 * @Date 2021/6/11 10:42
 * description :
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudStreamRabbitProviderApp8300 {
    public static void main(String[] args) {
        SpringApplication.run(CloudStreamRabbitProviderApp8300.class, args);
    }
}
