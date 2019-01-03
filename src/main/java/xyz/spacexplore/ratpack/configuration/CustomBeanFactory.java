package xyz.spacexplore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ratpack.spring.config.RatpackServerCustomizer;

@Configuration
public class CustomBeanFactory {
    @Bean
    RatpackServerCustomizer ratpackServerSpec(final CustomRatpackProperties ratpackProperties) {
        return new CustomRatPackServerConfig(ratpackProperties);
    }
}
