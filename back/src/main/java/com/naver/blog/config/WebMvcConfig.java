package com.naver.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.naver.blog.interceptor.SampleInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("*"); // when it service web server then it change for that url.
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SampleInterceptor())
                .excludePathPatterns("/css/**", "/images/**", "/js/**"
                		, "/swagger-ui/**", "/swagger-resources/**", "/v2/api-docs/**", "/error");
    }

}
