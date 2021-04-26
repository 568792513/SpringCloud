package org.hui.payment.service.impl;

import org.hui.entity.Payment;

import org.springframework.stereotype.Service;
import org.hui.payment.dao.PaymentDao;
import org.hui.payment.service.PaymentService;

import javax.annotation.Resource;

/**
 * @Author zh
 * @Date 2021/2/1 11:05
 * description :
 */
@Service
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
}
