package com.chiiiplow.butler.config;


import com.chiiiplow.butler.interceptor.LogTraceInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 管家网络配置
 *
 * @author yangzhixiong
 * @date 2025/10/13
 */
@Configuration
public class ButlerWebConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogTraceInterceptor()).addPathPatterns("/**");
    }
}
