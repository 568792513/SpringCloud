package org.hui.payment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author zh
 * @Date 2021/1/29 15:47
 * description :
 */
@Data
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
