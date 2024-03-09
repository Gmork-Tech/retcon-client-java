import config.RetconConfig;
import io.smallrye.config.SmallRyeConfig;
import org.eclipse.microprofile.config.ConfigProvider;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class Retcon extends WebSocketClient {

    private Retcon(URI uri) {
        super(uri);
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {

    }

    @Override
    public void onMessage(String s) {

    }

    @Override
    public void onClose(int i, String s, boolean b) {

    }

    @Override
    public void onError(Exception e) {

    }

    public static Retcon fromConfigName(String name) {
        // Get the config by name from any SmallRye ConfigProvider
        var config = ConfigProvider
                .getConfig()
                .unwrap(SmallRyeConfig.class)
                .getConfigMapping(RetconConfig.class)
                .clients()
                .get(name);

        if (config == null) {
            throw new RuntimeException("Unable to find config for name: " + name);
        }

        // Create a new Retcon instance
        return fromConfig(config);
    }

    public static Retcon fromConfig(RetconConfig.RetconClientConfig config) {
        var uri = URI.create(config.scheme() + "://" + config.host() + "/ws/" + config.appId());
        var retcon = new Retcon(uri);
        retcon.connect();
        return retcon;
    }

}