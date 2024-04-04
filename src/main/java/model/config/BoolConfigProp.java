package model.config;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BoolConfigProp extends ConfigProp {
    private Boolean val;
    private Boolean dval;

    @Override
    public boolean hasValue() {
        return val != null;
    }

}
