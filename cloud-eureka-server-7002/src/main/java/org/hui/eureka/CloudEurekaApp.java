package org.hui.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author zh
 * @Date 2021/4/21 11:06
 * description :
 */
@EnableEurekaServer
@SpringBootApplication
public class CloudEurekaApp {
    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaApp.class, args);
    }
}
