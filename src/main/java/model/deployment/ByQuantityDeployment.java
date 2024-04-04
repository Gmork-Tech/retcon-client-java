package model.deployment;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Duration;
import java.time.Instant;

@Data
@EqualsAndHashCode(callSuper = true)
public class ByQuantityDeployment extends Deployment {
    private Instant lastDeployed;
    private Short incrementQuantity;
    private Short initialQuantity = 1;
    private boolean shouldIncrement = false;
    private Duration incrementDelay = Duration.ofMinutes(5);
    private Short targetQuantity;
}
