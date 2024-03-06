package ua.sviatik.formatters.suppliers;

import ua.sviatik.entity.Student;
import ua.sviatik.formatters.Formatter;
import ua.sviatik.formatters.impl.StudentFormatter;

public class StudentFormatterSupplier implements Supplier<Student>{

    @Override
    public Formatter<Student> get() {
        return new StudentFormatter();
    }
}
