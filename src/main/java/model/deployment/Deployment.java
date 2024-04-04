package model.deployment;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import model.config.ConfigProp;
import model.enums.DeploymentStrategy;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "kind")
@JsonSubTypes({
        @JsonSubTypes.Type(value = FullDeployment.class, name = DeploymentStrategy.Values.FULL),
        @JsonSubTypes.Type(value = ByQuantityDeployment.class, name = DeploymentStrategy.Values.BY_QUANTITY),
        @JsonSubTypes.Type(value = ByPercentDeployment.class, name = DeploymentStrategy.Values.BY_PERCENTAGE),
        @JsonSubTypes.Type(value = PartialManualDeployment.class, name = DeploymentStrategy.Values.MANUAL)
})
public abstract class Deployment {
    private long id;
    private String name;
    private short priority = 100;
    private Set<ConfigProp> props;
}
