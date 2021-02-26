package org.hui.payment.service;

import org.apache.ibatis.annotations.Param;
import org.hui.payment.dao.PaymentDao;
import org.hui.payment.entity.Payment;

import javax.annotation.Resource;

/**
 * @Author zh
 * @Date 2021/2/1 11:05
 * description :
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
