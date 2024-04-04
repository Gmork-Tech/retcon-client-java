package model.config;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import model.enums.ValueType;

import java.time.Instant;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "kind")
@JsonSubTypes({
        @JsonSubTypes.Type(value = StringConfigProp.class, name = ValueType.Values.STRING),
        @JsonSubTypes.Type(value = NumericConfigProp.class, name = ValueType.Values.NUMBER),
        @JsonSubTypes.Type(value = BoolConfigProp.class, name = ValueType.Values.BOOLEAN),
        @JsonSubTypes.Type(value = TimestampConfigProp.class, name = ValueType.Values.TIMESTAMP),
        @JsonSubTypes.Type(value = ObjectConfigProp.class, name = ValueType.Values.OBJECT),
        @JsonSubTypes.Type(value = ArrayConfigProp.class, name = ValueType.Values.ARRAY),
})
public abstract class ConfigProp implements Comparable<ConfigProp> {
    private long id;
    private String name;
    private boolean nullable = false;
    private Instant created = Instant.now();
    private Integer priority;

    public abstract boolean hasValue();

    @Override
    public int compareTo(ConfigProp o) {
        return o.priority.compareTo(priority);
    }
}
