package model.config;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Duration;

@Data
@EqualsAndHashCode(callSuper = true)
public class DurationConfigProp extends ConfigProp {
    private Duration val;
    private Duration dval;

    @Override
    public boolean hasValue() {
        return val != null;
    }

}
