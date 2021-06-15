package org.hui.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.hui.entity.Payment;
import org.hui.entity.Result;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author zh
 * @Date 2021/6/3 15:20
 * description :
 */
@Component
public class PaymentFeignHystrixServiceFallback implements PaymentFeignHystrixService {

    @Override
    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
    public Result<Payment> ok(@PathVariable("id") Long id) {
        return new Result<>(500, "服务器出错了");
    }

    @Override
    public Result<Payment> timeout(Long id) {
        return null;
    }
}
