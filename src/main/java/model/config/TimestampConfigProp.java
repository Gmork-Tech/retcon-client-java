package model.config;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;

@Data
@EqualsAndHashCode(callSuper = true)
public class TimestampConfigProp extends ConfigProp {
    private Instant val;
    private Instant dval;

    @Override
    public boolean hasValue() {
        return val != null;
    }

}
