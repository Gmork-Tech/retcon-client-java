package model.deployment;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class PartialManualDeployment extends Deployment {
    private Set<String> targetHosts;
}
