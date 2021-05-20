package com.mlk.cache.springbootcache.config;

import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author malikai
 * @date 2021年05月20日 14:22
 */
@Configuration
public class WebConfig{

    @Configuration
    public class BeetlConf {
        private final Logger logger = LoggerFactory.getLogger(getClass());

        @Bean(name = "beetlConfig")
        public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
            BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
            ClasspathResourceLoader classpathResourceLoader = new ClasspathResourceLoader();
            beetlGroupUtilConfiguration.setResourceLoader(classpathResourceLoader);
            beetlGroupUtilConfiguration.init();
            return beetlGroupUtilConfiguration;
        }
        @Bean(name = "beetlViewResolver")
        public BeetlSpringViewResolver getBeetlSpringViewResolver(
                @Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
            BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
            //beetlSpringViewResolver.setPrefix("/templates/");
            beetlSpringViewResolver.setSuffix(".html");
            beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
            beetlSpringViewResolver.setOrder(0);
            beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
            return beetlSpringViewResolver;
        }
    }
}
