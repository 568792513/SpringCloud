package org.hui;

import org.myRule.MyRibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author zh
 * @Date 2021/4/21 9:47
 * description :
 */
@SpringBootApplication
@EnableEurekaClient
@LoadBalancerClient(value = "provider-payment", configuration = MyRibbonRule.class)
public class CloudConsumerOrderApp {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrderApp.class, args);
    }
}
