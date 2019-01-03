package xyz.spacexplore.ratpack.configuration;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import ratpack.spring.config.RatpackProperties;

import java.net.InetAddress;

@Configuration
@Primary
public class CustomRatpackProperties extends RatpackProperties {
  @Value("${spring.ratpack.isDevelopment}")
  public boolean isDevelopment;

  public String address;

  private Integer sessionTimeout;

  private String contextPath = "";

  private String templatesPath = "templates";

  private int cacheSize = 100;

  private boolean staticallyCompile;


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
