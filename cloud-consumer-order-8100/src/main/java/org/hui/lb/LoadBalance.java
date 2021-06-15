package org.hui.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author zh
 * @Date 2021/6/1 15:29
 * description :
 */
public interface LoadBalance {

    ServiceInstance instances(List<ServiceInstance> serviceInstanceList);


}
