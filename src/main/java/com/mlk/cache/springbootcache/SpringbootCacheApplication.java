package com.mlk.cache.springbootcache;

import com.mlk.cache.springbootcache.delay.SpringContextUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.mlk.cache")
@EnableSwagger2
@ConditionalOnProperty(name = "swagger.enable",  havingValue = "true")
@EnableCaching
public class SpringbootCacheApplication {

	public static void main(String[] args) {
		ApplicationContext app =  SpringApplication.run(SpringbootCacheApplication.class, args);
		SpringContextUtil.setApplicationContext(app);
		System.out.println("启动完成");
	}

}
