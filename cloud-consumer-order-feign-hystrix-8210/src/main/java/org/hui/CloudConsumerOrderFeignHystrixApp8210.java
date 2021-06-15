package org.hui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author zh
 * @Date 2021/6/2 10:44
 * description :
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
public class CloudConsumerOrderFeignHystrixApp8210 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrderFeignHystrixApp8210.class, args);
    }
}
