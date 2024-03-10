package config;

import io.smallrye.config.WithDefault;

public interface RetconClientConfig {
    @WithDefault(value = "ws")
    String scheme();
    @WithDefault(value = "localhost:8080")
    String host();
    String appId();
}