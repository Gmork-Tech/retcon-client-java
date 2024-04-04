package model.config;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class StringConfigProp extends ConfigProp {
    private String val;
    private String dval;

    @Override
    public boolean hasValue() {
        return val != null;
    }

}
