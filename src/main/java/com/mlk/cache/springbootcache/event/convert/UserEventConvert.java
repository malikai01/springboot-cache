package com.mlk.cache.springbootcache.event.convert;

import com.mlk.cache.springbootcache.event.UserChangeEvent;
import com.mlk.cache.springbootcache.model.Users;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

/**
 * 转换对象
 *
 * @author malikai
 * @version 1.0
 * @date 2021-5-8 15:51
 */
@Service
public class UserEventConvert implements Converter<Users, UserChangeEvent> {

    @Override
    public UserChangeEvent convert(Users users) {
        return new UserChangeEvent(users);
    }
}
