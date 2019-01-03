package xyz.spacexplore.configuration;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import ratpack.spring.config.RatpackProperties;

@Configuration
@Data
@Builder
@NoArgsConstructor
public class CustomRatpackProperties extends RatpackProperties {
  @Value("${spring.ratpack.isDevelopment}")
  public boolean isDevelopment;

  @Value("${spring.ratpack.port}")
  public int port;

  @Value("${spring.ratpack.maxContentLength}")
  public int maxContentLength;

  @Value("${spring.ratpack.connectTimeoutMillis}")
  public int connectTimeoutMillis;

  @Value("${spring.ratpack.threads}")
  public int threads;

  @Value("${spring.ratpack.receiveBufferSize}")
  public int receiveBufferSize;

  @Value("${spring.ratpack.maxMessagesPerRead}")
  public int maxMessagesPerRead;

  public int connectQueueSize = Integer.MAX_VALUE;

  public boolean isDevelopment() {
    return false;
  }
}
