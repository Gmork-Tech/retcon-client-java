package model.config;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
public class ObjectConfigProp extends ConfigProp {
    private Map<String,Object> val;
    private Map<String,Object> dval;

    @Override
    public boolean hasValue() {
        return val != null;
    }

}
