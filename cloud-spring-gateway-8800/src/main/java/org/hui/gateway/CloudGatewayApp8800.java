package org.hui.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author zh
 * @Date 2021/6/7 16:02
 * description :
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudGatewayApp8800 {
    public static void main(String[] args) {
        SpringApplication.run(CloudGatewayApp8800.class, args);
    }
}
