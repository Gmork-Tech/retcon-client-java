package config;

import io.smallrye.config.ConfigMapping;

import java.util.Map;

@ConfigMapping(prefix = "retcon")
public interface RetconConfig {

    Map<String, RetconClientConfig> clients();

}