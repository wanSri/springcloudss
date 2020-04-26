package com.zj.springcloud.service;

import com.zj.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * TODO
 *
 * @author wansri
 * @data 2020/4/24 10:14 下午
 */
public interface IPaymentService {

    public int create(Payment payment);

    public  Payment getPaymentById(@Param("id") Long id);
}
