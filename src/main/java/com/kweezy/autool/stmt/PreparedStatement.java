package com.kweezy.autool.stmt;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;

import java.io.IOException;
import java.util.Comparator;

public abstract class PreparedStatement<T>
{
    public static final Comparator<PreparedStatement<?>> comparator;
    public final int blockId;
    public final Class<T> blockClass;

    static {
        comparator = new Comparator<PreparedStatement<?>>() {
            public int compare(final PreparedStatement<?> d, final PreparedStatement<?> d2) {
                return d.blockId - d2.blockId;
            }
        };
    }

    public PreparedStatement(final int b, final Class<T> c) {
        this.blockId = b;
        this.blockClass = c;
    }

    public abstract T read(final ObjectReader reader) throws IOException;

    public abstract void write(final ObjectWriter writer, final T p1) throws IOException;
}
