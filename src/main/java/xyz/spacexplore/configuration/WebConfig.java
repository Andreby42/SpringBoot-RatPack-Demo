package xyz.spacexplore.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;
import xyz.spacexplore.interceptor.CommonInterceptor;

import javax.annotation.Resource;

/**
 * web config
 */
@Configuration
@Slf4j
@ComponentScan(value="xyz.spacexplore")
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private CommonInterceptor commonInterceptor;

    @Bean
    ServletWebServerFactory servletWebServerFactory(){
        log.debug("TomcatServletWebServerFactoryRegistor initing..................");
        return new TomcatServletWebServerFactory();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.debug("InterceptorsRegistor initing..................");
        registry.addWebRequestInterceptor(commonInterceptor);
    }
    @Bean
    public FilterRegistrationBean registFilter() {
        log.debug("FilterRegistor initing..................");
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new ResourceUrlEncodingFilter());
        registration.addUrlPatterns("/*");
        registration.setOrder(1);
        return registration;
    }
}
