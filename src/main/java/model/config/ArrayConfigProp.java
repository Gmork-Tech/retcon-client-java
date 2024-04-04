package model.config;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ArrayConfigProp extends ConfigProp {
    private List<Object> val;
    private List<Object> dval;

    @Override
    public boolean hasValue() {
        return val != null;
    }

}
