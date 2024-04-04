package model.config;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NumericConfigProp extends ConfigProp {
    private Number val;
    private Number dval;

    @Override
    public boolean hasValue() {
        return val != null;
    }

}
