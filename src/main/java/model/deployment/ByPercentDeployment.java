package model.deployment;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Duration;
import java.time.Instant;

@Data
@EqualsAndHashCode(callSuper = true)
public class ByPercentDeployment extends Deployment {
    private Instant lastDeployed;
    private boolean shouldIncrement = false;
    private Duration incrementDelay = Duration.ofMinutes(5);
    private Short incrementPercentage = 5;
    private Short initialPercentage = 5;
    private Short targetPercentage = 100;
}
