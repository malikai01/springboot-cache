package com.mlk.cache.springbootcache.delay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author ****
 * @date 2021/7/14
 * 订单支付超时处理类
 */
@Component
@Slf4j
public class ConsumeOrderPayTimeout implements RedisDelayQueueHandle<Map> {


    @Override
    public void execute(Map map) {
        log.info("(收到订单支付超时延迟消息) {}", map);

        //你的业务逻辑代码

    }
}
