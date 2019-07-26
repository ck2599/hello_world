package com.czxy.config;

import com.czxy.Interceptor.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 1519389876@qq.com
 * @version v 1.0
 * @date 2019/7/25  11:11
 * @infos
 */

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
    @Autowired
    private Interceptor interceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/**");
    }
}
