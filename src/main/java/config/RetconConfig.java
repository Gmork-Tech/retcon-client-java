package config;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;

import java.util.Map;

@ConfigMapping(prefix = "retcon")
public interface RetconConfig {

    Map<String, RetconClientConfig> clients();

    interface RetconClientConfig {
        @WithDefault(value = "ws")
        String scheme();
        @WithDefault(value = "localhost:8080")
        String host();
        String appId();
    }
}