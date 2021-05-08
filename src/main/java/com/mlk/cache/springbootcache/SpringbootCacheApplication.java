package com.mlk.cache.springbootcache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mlk.cache")
public class SpringbootCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCacheApplication.class, args);
	}

}
