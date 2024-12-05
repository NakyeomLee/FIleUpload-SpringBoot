package com.metacoding.upload;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

// 설정 파일

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);

        // 1. 절대경로 file:///c:/upload/ => /// 슬래쉬 3개는 localhost가 생략돼있는것
        // 2. 상대경로 file:./upload/
        registry
                .addResourceHandler("/upload/**") // html에서 경로를 적으면
                .addResourceLocations("file:" + "./images/") // 웹서버의 /images/ 폴더 경로를 찾음
                .setCachePeriod(60 * 60); // 초 단위 => 한시간
    }
}