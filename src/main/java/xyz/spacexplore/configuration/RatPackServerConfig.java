package xyz.spacexplore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ratpack.server.BaseDir;
import ratpack.server.ServerConfig;

@Configuration
public class RatPackServerConfig {
  @Bean
  public ServerConfig serverConfig() {
    return ServerConfig
        .builder()
//        .findBaseDir("/static")
        .baseDir(BaseDir.find())
        .port(9527)
        .development(true)
        .maxContentLength(102400000)
        .connectTimeoutMillis(30 * 1000)
        .threads(64)
        .receiveBufferSize(2024*1024)
        .maxMessagesPerRead(2024*1024)
        .connectQueueSize(Integer.MAX_VALUE)
        //.etc
        .build();
  }

}
