package ua.sviatik.formatters;

import java.util.Set;

public interface Formatter<T> {
    String format(Set<T> obj);
}
