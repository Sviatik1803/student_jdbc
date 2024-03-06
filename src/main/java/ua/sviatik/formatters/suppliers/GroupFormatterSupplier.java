package ua.sviatik.formatters.suppliers;

import ua.sviatik.entity.Group;
import ua.sviatik.formatters.Formatter;
import ua.sviatik.formatters.impl.GroupFormatter;

public class GroupFormatterSupplier implements Supplier<Group>{

    @Override
    public Formatter<Group> get() {
        return new GroupFormatter();
    }
}
