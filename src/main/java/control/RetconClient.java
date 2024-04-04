package control;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Getter;
import lombok.Setter;
import model.config.*;
import model.deployment.Deployment;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Getter
@Setter
public class RetconClient extends WebSocketClient {

    private static final JsonMapper mapper = JsonMapper
            .builder()
            .addModule(new JavaTimeModule())
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .build();

    private Retcon parent;

    public RetconClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {

    }

    @Override
    public void onMessage(String s) {
        try {
            if (parent == null || parent.getProps() == null) {
                throw new RuntimeException("Parent abstraction should never be null in RetConClient.");
            }
            var deployment = mapper.readValue(s, Deployment.class);
            for (var prop : deployment.getProps()) {
                if (prop == null) {
                    continue;
                }
                if (prop instanceof ArrayConfigProp) {
//                    if (parent.getProps().getArrays().containsKey(prop.getName())) {
//                        var arraySet = parent.getProps().getArrays().get(prop.getName());
//                        parent.getProps().getArrays().computeIfPresent(prop.getName(), (name, set) -> {
//                            set.stream().filter(val -> val.getId() != prop.getId()).re
//                        });
//                        arraySet.stream().filter(val -> val.getId() != prop.getId()).collect(Collectors.toSet());
//
//                    } else {
//                        parent.getProps().getArrays().put(prop.getName(), new TreeSet<>());
//                        parent.getProps().getArrays().get(prop.getName()).add((ArrayConfigProp) prop);
//                    }
                } else if (prop instanceof BoolConfigProp) {

                } else if (prop instanceof DurationConfigProp) {

                } else if (prop instanceof NumericConfigProp) {

                } else if (prop instanceof ObjectConfigProp) {

                } else if (prop instanceof StringConfigProp) {

                } else if (prop instanceof TimestampConfigProp) {

                }
            }
        } catch (Exception e) {

        }
    }

    @Override
    public void onClose(int i, String s, boolean b) {

    }

    @Override
    public void onError(Exception e) {

    }

}
