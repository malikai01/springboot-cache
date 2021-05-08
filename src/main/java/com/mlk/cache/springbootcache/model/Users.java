package com.mlk.cache.springbootcache.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author malikai
 * @version 1.0.0
 * @date 2021-4-25 16:26
 **/
@Data
@AllArgsConstructor
public class Users implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private Integer orgId;

}