package com.zj.springcloud.controller;

import com.zj.springcloud.entities.CommonResult;
import com.zj.springcloud.entities.Payment;
import com.zj.springcloud.service.IPaymentService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author wansri
 * @data 2020/4/24 10:18 下午
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private IPaymentService paymentService;

    @Value("${server.port}")
    private Integer port;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("***插入结果："+result);
        if(result>0){
            return new CommonResult(200,"插入数据库成功"+port,result);
        }else {
            return new CommonResult(404,"插入数据库失败"+port, null);
        }
    }


    @GetMapping("/payment/{id}/")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){

        Payment payment = paymentService.getPaymentById(id);
        if(payment!=null){
            return new CommonResult<Payment>(200,"查询成功！"+port,payment);
        }else {
            return new CommonResult<Payment>(400,"查询"+id+"失败"+port,null);
        }
    }

}
