package control;

import config.RetconClientConfig;
import config.RetconConfig;
import io.smallrye.config.SmallRyeConfigBuilder;
import lombok.Getter;
import model.PropMap;

import java.net.URI;


@Getter
public class Retcon {

    private final RetconClient client;

    private RetconClientConfig config;

    private final PropMap props = new PropMap();

    public Retcon(URI uri) {
        client = new RetconClient(uri);
        client.setParent(this);
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

        // Create a new control.Retcon instance
        return fromConfig(config);
    }

    public static Retcon fromConfig(RetconClientConfig config) {
        var uri = URI.create(config.scheme() + "://" + config.host() + "/ws/" + config.appId());
        var retcon = new Retcon(uri);
        retcon.config = config;
        retcon.client.connect();
        return retcon;
    }

}