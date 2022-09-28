package com.kweezy.autool.stmt.types;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.interfaces.readWriteData;

import java.io.IOException;
import java.util.AbstractCollection;

public final class ObjectArray implements readWriteData { // extends AbstractCollection<Object>
    private static final Object[] x0;
    private int length;
    private Object[] arrayOfObjects;

    static {
        x0 = new Object[0];
    }

    // @Override
    public int size() {
        return this.length;
    }

    @Override
    public void readData(final ObjectReader a) throws IOException {
        int l = a.unsigned_35();
        this.length = l;
        this.arrayOfObjects = new Object[l];
        int n = 0;
        while (--l >= 0) {
            this.arrayOfObjects[n] = a.readObject();
            ++n;
        }
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        int x1 = this.length;
        b.unsigned_35(x1);
        int n = 0;
        while (--x1 >= 0) {
            b.writeObject(this.arrayOfObjects[n]);
            ++n;
        }
    }
}