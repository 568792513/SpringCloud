package org.hui.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author zh
 * @Date 2021/1/29 15:47
 * description :
 */
@Data
public class Payment implements Serializable {
    private static final long serialVersionUID = -8483335428968680311L;
    private Long id;
    private String serial;
}
