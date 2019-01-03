package xyz.spacexplore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModuleBuild {

    @Bean
    public MetricProperties metricProperties(){
        return new MetricProperties();
    }
}
