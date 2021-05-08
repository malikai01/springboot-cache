package com.mlk.cache.springbootcache.event.util;

import com.mlk.cache.springbootcache.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @author malikai
 * @version 1.0
 * @date 2021-5-8 15:41
 */
@Service
@Slf4j
public class ApplicationEventUtil {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public <T extends ApplicationEvent> void sendChangeEventSingle(T event) {
        if (null == event) {
            return;
        }
        try {
            eventPublisher.publishEvent(event);
        } catch (Exception e) {
            log.error("send change event error for " + JsonUtil.object2JSON(event), e);
        }
    }

}
