package org.hui.payment.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.hui.entity.Payment;
import org.hui.payment.dao.PaymentDao;
import org.hui.payment.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author zh
 * @Date 2021/2/1 11:05
 * description :
 */
@Service
@Slf4j
@DefaultProperties(defaultFallback = "globalFallbackHandler")
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    @HystrixCommand
    public String paymentInfo_OK(Long id) {
        // int a = 10/0;
        log.info("线程： " + Thread.currentThread().getName());
        return "线程： " + Thread.currentThread().getName() + " paymentInfo_OK, id:" + id + "\t O(∩_∩)O";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), // 失败率达到多少后跳闸
    })
    public String paymentInfo_Timeout(Long id) {
        // try {
        //     TimeUnit.SECONDS.sleep(5);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        if (id < 0) {
            throw new RuntimeException("id不能为负数");
        }
        return "线程： " + Thread.currentThread().getName() + " paymentInfo_Timeout, id:" + id + "\t O(∩_∩)O";
    }

    public String paymentInfo_TimeoutHandler(Long id) {
        return "线程： " + Thread.currentThread().getName() + " paymentInfo_TimeoutHandler, id:" + id + "\t [FallbackMethod] " + "服务器忙无法响应，请稍后再试";
    }

    public String globalFallbackHandler() {
        return "线程： " + Thread.currentThread().getName() + " globalFallbackHandler, 服务器忙无法响应，请稍后再试";
    }
}
