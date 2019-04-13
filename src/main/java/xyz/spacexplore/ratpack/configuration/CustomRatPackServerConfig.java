package xyz.spacexplore.ratpack.configuration;

import lombok.extern.slf4j.Slf4j;
import ratpack.func.Action;
import ratpack.guice.BindingsSpec;
import ratpack.handling.Chain;
import ratpack.server.ServerConfigBuilder;
import ratpack.spring.config.RatpackServerCustomizerAdapter;

import java.util.List;

/** 另一种配置RatPack的方式 在这里感谢 Hubert Klein Ikkink */
@Slf4j
public class CustomRatPackServerConfig extends RatpackServerCustomizerAdapter {

  private final CustomRatpackProperties ratpackConfiguration;

  public CustomRatPackServerConfig(CustomRatpackProperties ratpackConfiguration) {
    this.ratpackConfiguration = ratpackConfiguration;
  }

  @Override
  public List<Action<Chain>> getHandlers() {
    return super.getHandlers();
  }

  @Override
  public Action<BindingsSpec> getBindings() {
    return super.getBindings();
  }

  @Override
  public Action<ServerConfigBuilder> getServerConfig() {
      log.info("ratpack serverconfig load compelete!");
    return serverConfigBuilder ->
        serverConfigBuilder.development(ratpackConfiguration.isDevelopment())
                .port(ratpackConfiguration.port)
                .maxContentLength(ratpackConfiguration.maxContentLength)
                .connectTimeoutMillis(ratpackConfiguration.connectTimeoutMillis)
                .threads(ratpackConfiguration.threads)
                .receiveBufferSize(ratpackConfiguration.receiveBufferSize)
                .maxMessagesPerRead(ratpackConfiguration.maxMessagesPerRead)
                .connectQueueSize(ratpackConfiguration.connectQueueSize)
                // .etc
                .build();
  }

}
