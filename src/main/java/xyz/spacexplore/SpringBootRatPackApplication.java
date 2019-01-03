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
      return chain -> chain.get(ctx -> ctx.render("Hello "));
  }

}
