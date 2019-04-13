package xyz.spacexplore.ratpack.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ratpack.spring.config.RatpackServerCustomizer;

@Configuration
@Slf4j
public class CustomBeanFactory {
    @Bean
    RatpackServerCustomizer ratpackServerSpec(final CustomRatpackProperties ratpackProperties) {
        log.info("ratpack CustomBeanFactory load compelete!");
        return new CustomRatPackServerConfig(ratpackProperties);
    }
}
