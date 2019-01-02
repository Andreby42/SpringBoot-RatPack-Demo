package xyz.spacexplore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ratpack.func.Action;
import ratpack.handling.Chain;
import ratpack.registry.Registry;
import ratpack.server.BaseDir;
import ratpack.server.RatpackServer;
import ratpack.spring.Spring;
import ratpack.spring.config.EnableRatpack;

@SpringBootApplication
@EnableRatpack
public class SpringBootRatPackApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootRatPackApplication.class, args);
  }
  
  @Bean
  public Action<Chain> home() {
    return chain -> chain
      .get(ctx -> ctx
        .render("Hello " )
      );
  }
//  @Bean
  public RatpackServer ratpackServer() {
    Registry springBoot = Spring.spring(SpringBootRatPackApplication.class);
    try {
      RatpackServer of = RatpackServer.of(server->{
        server.serverConfig(serverConfigBuilder -> {
          serverConfigBuilder.baseDir(BaseDir.find());
          serverConfigBuilder.port(9527);
          serverConfigBuilder.development(true);
          serverConfigBuilder.maxContentLength(102400000); 
          serverConfigBuilder.connectTimeoutMillis(30 * 1000); 
          serverConfigBuilder.threads(64);
          serverConfigBuilder.receiveBufferSize(1024*1024);
          serverConfigBuilder.maxMessagesPerRead(1024*1024);
          serverConfigBuilder.connectQueueSize(Integer.MAX_VALUE);
        }).registry(springBoot).handlers(chain -> {
          chain.all(ctx -> {
              ctx.redirect("/");
          });
      });
      });
      return of;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}

