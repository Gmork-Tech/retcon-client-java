package model;

import lombok.Data;
import model.config.*;

import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class PropMap {
    private Map<String, SortedSet<BoolConfigProp>> booleans = new ConcurrentHashMap<>();
    private Map<String, SortedSet<TimestampConfigProp>> timestamps = new ConcurrentHashMap<>();
    private Map<String, SortedSet<DurationConfigProp>> durations = new ConcurrentHashMap<>();
    private Map<String, SortedSet<StringConfigProp>> strings = new ConcurrentHashMap<>();
    private Map<String, SortedSet<NumericConfigProp>> numbers = new ConcurrentHashMap<>();
    private Map<String, SortedSet<ObjectConfigProp>> objects = new ConcurrentHashMap<>();
    private Map<String, SortedSet<ArrayConfigProp>> arrays = new ConcurrentHashMap<>();
}
