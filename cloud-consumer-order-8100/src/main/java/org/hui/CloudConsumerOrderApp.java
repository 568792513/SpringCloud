package org.hui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author zh
 * @Date 2021/4/21 9:47
 * description :
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudConsumerOrderApp {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrderApp.class, args);
    }
}
