package org.hui.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author zh
 * @Date 2021/4/21 9:47
 * description :
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsumerOrderApp {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrderApp.class, args);
    }
}
