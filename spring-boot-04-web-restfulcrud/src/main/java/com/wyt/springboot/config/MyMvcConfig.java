package com.wyt.springboot.config;

import com.wyt.springboot.component.MyLocaleResolver;
import org.springframework.boot.web.server.AbstractConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//使用WebMvcConfigurer可以扩展SpringMVC的功能
@Configuration
//@EnableWebMvc
public class MyMvcConfig implements WebMvcConfigurer {

    @Bean
    public WebServerFactoryCustomizer<AbstractConfigurableWebServerFactory> myWebServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<AbstractConfigurableWebServerFactory>() {
            @Override
            public void customize(AbstractConfigurableWebServerFactory factory) {
                factory.setPort(9999);
            }
        };
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送/wyt请求,将来到success页面
        registry.addViewController("/wyt").setViewName("success");
    }

    //所有的webMvcConfig都会一起起作用
    @Bean   //将组件注册到容器
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer configurer = new WebMvcConfigurer(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("index.html").setViewName("login");
                registry.addViewController("main.html").setViewName("dashboard");
            }

//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                //静态资源:*.css,*.js
//                //SpringBoot已经做好了静态资源映射
//                registry.addInterceptor(new LoginHandlerInterceptor())
//                            .addPathPatterns("/**")
//                            .excludePathPatterns("/index.html","/","/user/login","/webjars/**","/asserts/**");
//            }
        };
        return configurer;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
