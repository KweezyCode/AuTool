package com.kweezy.stmt;

import com.kweezy.ObjectReader;
import com.kweezy.ObjectWriter;

import java.io.IOException;
import java.util.Comparator;

public abstract class PreparedBlock<T>
{
    public static final Comparator<PreparedBlock<?>> comparator;
    public final int blockId;
    public final Class<T> blockClass;

    static {
        comparator = new Comparator<PreparedBlock<?>>() {
            public int compare(final PreparedBlock<?> d, final PreparedBlock<?> d2) {
                return d.blockId - d2.blockId;
            }
        };
    }

    public PreparedBlock(final int b, final Class<T> c) {
        this.blockId = b;
        this.blockClass = c;
    }

    public abstract T read(final ObjectReader reader) throws IOException;

    public abstract void write(final ObjectWriter writer, final T p1) throws IOException;
}
