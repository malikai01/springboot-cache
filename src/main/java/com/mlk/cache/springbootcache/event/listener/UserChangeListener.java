package com.mlk.cache.springbootcache.event.listener;

import com.mlk.cache.springbootcache.event.UserChangeEvent;
import com.mlk.cache.springbootcache.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * 监听用户变更事件
 *
 * @author malikai
 * @version 1.0
 * @date 2021-5-8 15:58
 */
@Slf4j
@Service
public class UserChangeListener {

    @EventListener
    public void handleUserChangeListener(UserChangeEvent userChangeEvent) {
        //listen message do anything
        log.info("listen user change event :{}", JsonUtil.object2JSON(userChangeEvent.getSource()));
    }
}
