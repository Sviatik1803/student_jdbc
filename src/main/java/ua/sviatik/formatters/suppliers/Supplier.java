package ua.sviatik.formatters.suppliers;

import ua.sviatik.formatters.Formatter;

public interface Supplier<T> {
    Formatter<T> get();
}
