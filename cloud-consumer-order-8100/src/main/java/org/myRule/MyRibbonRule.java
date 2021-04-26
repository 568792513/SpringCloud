package org.myRule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zh
 * @Date 2021/4/23 15:27
 * description :
 */
@Configuration
public class MyRibbonRule extends AbstractLoadBalancerRule {
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }

    @Override
    public Server choose(Object key) {
        return null;
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}
