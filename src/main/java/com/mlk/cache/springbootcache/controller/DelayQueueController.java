package com.mlk.cache.springbootcache.controller;

import com.mlk.cache.springbootcache.delay.RedisDelayQueueEnum;
import com.mlk.cache.springbootcache.delay.RedisDelayQueueUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Api(tags = "延迟队列")
@RestController
@RequestMapping(value = "/delay")
@Slf4j
public class DelayQueueController {

    @Autowired
    RedisDelayQueueUtil redisDelayQueueUtil;

    @GetMapping("orderId")
    public void orderId() {
        Map<String, Object> param = new HashMap<>(2);
        param.put("orderId", "1415626985311772674");
        param.put("remark", "订单支付超时，自动取消订单");
        // 添加订单支付超时，自动取消订单延迟队列。为了测试效果，延迟10秒钟
        redisDelayQueueUtil.addDelayQueue(param, 10, TimeUnit.MINUTES, RedisDelayQueueEnum.CONSUME_ORDER_PAY_TIMEOUT.getCode());
    }
}
