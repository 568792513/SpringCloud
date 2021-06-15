package org.hui.payment.service;


import org.hui.entity.Payment;

/**
 * @Author zh
 * @Date 2021/2/1 11:05
 * description :
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);

    String paymentInfo_OK(Long id);

    String paymentInfo_Timeout(Long id);
}
