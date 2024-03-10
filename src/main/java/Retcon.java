import config.RetconClientConfig;
import config.RetconConfig;
import io.smallrye.config.SmallRyeConfigBuilder;

import java.net.URI;

public class Retcon {

    private final RetconClient client;
    private RetconClientConfig config;

    public Retcon(URI uri) {
        client = new RetconClient(uri);
    }

    public RetconClient getClient() {
        return client;
    }

    public RetconClientConfig getConfig() {
        return config;
    }

    private void setConfig(RetconClientConfig config) {
        this.config = config;
    }

    public static Retcon fromConfigName(String name) {
        // Get the config by name from any SmallRye ConfigProvider
        var config = new SmallRyeConfigBuilder()
                .addDefaultInterceptors()
                .addDefaultSources()
                .withMapping(RetconConfig.class)
                .build()
                .getConfigMapping(RetconConfig.class)
                .clients()
                .get(name);

        if (config == null) {
            throw new RuntimeException("Unable to find config for name: " + name);
        }

        // Create a new Retcon instance
        return fromConfig(config);
    }

    public static Retcon fromConfig(RetconClientConfig config) {
        var uri = URI.create(config.scheme() + "://" + config.host() + "/ws/" + config.appId());
        var retcon = new Retcon(uri);
        retcon.getClient().connect();
        retcon.setConfig(config);
        return retcon;
    }

}