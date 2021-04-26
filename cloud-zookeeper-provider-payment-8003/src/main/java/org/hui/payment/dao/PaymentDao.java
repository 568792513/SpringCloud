package org.hui.payment.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hui.entity.Payment;


/**
 * @Author zh
 * @Date 2021/1/29 15:57
 * description :
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
