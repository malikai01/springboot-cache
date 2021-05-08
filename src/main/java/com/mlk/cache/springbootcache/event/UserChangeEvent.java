package com.mlk.cache.springbootcache.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author malikai
 * @version 1.0
 * @date 2021-5-8 15:34
 */
public class UserChangeEvent<T> extends ApplicationEvent {
    public UserChangeEvent(T source) {
        super(source);
    }
}
