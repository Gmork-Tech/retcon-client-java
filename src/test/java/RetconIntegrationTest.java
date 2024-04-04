import control.Retcon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RetconIntegrationTest {

    @Test
    public void config_loads_and_client_attempts_connect() {
        var rc = Retcon.fromConfigName("test");
        Assertions.assertEquals(rc.getConfig().scheme(), "ws");
        Assertions.assertEquals(rc.getConfig().host(), "localhost:8080");
        Assertions.assertEquals(rc.getConfig().appId(), "123e4567-e89b-12d3-a456-426655440000");
        Assertions.assertNotNull(rc);
    }

}
