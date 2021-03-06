package xyz.spacexplore.ratpack.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ratpack.func.Action;
import ratpack.handling.Chain;
import ratpack.handling.RequestLogger;
import xyz.spacexplore.ratpack.handlers.RatPackHandler;

/**
 * ===================================================================================== @Filename :
 * RatPackRestries.java @Description : SpringBoot提供的ratpack注册表类 @Version : 1.0 @Created :
 * 2019年1月3日上午12:45:55 @Author : andreby
 *
 * <p>=====================================================================================
 */
@Configuration
@Slf4j
public class RatPackRegisties {
  // 一个handler
  @Bean
  public RatPackHandler ratPackHandler() {
    return name -> name + ": THIS IS A MSG";
  }
  @Bean
  Action<Chain> messageHandler() {
    return chain ->
        chain
            // Add logging for requests.
            .all(RequestLogger.ncsa())
            .get(
                "message/:name?",
                ctx -> {
                  final String name = ctx.getPathTokens().getOrDefault("name", "andreby");
                  // Use MessageService implementation added to Spring context.
                  final String message = ctx.get(RatPackHandler.class).message(name);
                  ctx.render(message);
                });
  }

}
