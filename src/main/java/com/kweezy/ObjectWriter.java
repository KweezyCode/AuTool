package com.kweezy;

import com.kweezy.stmt.BlocksInit;
import com.kweezy.stmt.PreparedBlock;
import com.kweezy.stmt.readWriteData;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.OutputStream;
import java.util.IdentityHashMap;

public class ObjectWriter extends Writers {
    private int currentVersion;
    private final IdentityHashMap<Object, Integer> y0;
    private boolean stringFlag;

    public ObjectWriter(final OutputStream outputStream) {
        super(outputStream);
        this.y0 = new IdentityHashMap<Object, Integer>();
    }

    public void setStringFlag(final boolean y1) {
        this.stringFlag = y1;
    }

    public void setVersion(final int x1) {
        this.currentVersion = x1;
    }

    public int version() {
        return this.currentVersion;
    }

    public <T> void writeObject(final Object obj) throws IOException { // <T> was added automatically
        int n;
        if (obj == null) {
            n = 0;
        }
        else {
            final Integer n2 = this.y0.get(obj);
            if (n2 != null) {
                n = -n2;
            }
            else {
                final PreparedBlock<T> preparedblock = (PreparedBlock<T>) BlocksInit.get().c(obj.getClass()); // TODO: Fix (T)
                if (preparedblock != null) {
                    final IdentityHashMap<Object, Integer> y0 = this.y0;
                    y0.put(obj, y0.size() + 1);

                    this.transform_35(preparedblock.blockId);
                    preparedblock.write(this, (T) obj); // TODO: Fix (T)
                    return;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("Illegal object: ");
                sb.append(obj.getClass());
                throw new InvalidObjectException(sb.toString());
            }
        }
        this.transform_35(n);
    }

    public <T> void o(final T[] array) throws IOException {
        int length = array.length;
        this.unsigned_35(length);
        int n = 0;
        while (--length >= 0) {
            this.writeObject(array[n]);
            ++n;
        }
    }

    public <T extends readWriteData> void q(final T[] array) throws IOException {
        int length = array.length;
        this.unsigned_35(length);
        int n = 0;
        while (--length >= 0) {
            array[n].writeData(this);
            ++n;
        }
    }

    public void r(String s) throws IOException {
        if (s == null) {
            s = "";
        }
        this.writeUTF(s);
    }

    public void s(final String[] array) throws IOException {
        int length = array.length;
        this.unsigned_35(length);
        int n = 0;
        while (--length >= 0) {
            this.r(array[n]);
            ++n;
        }
    }

    public void writeVersion(final int n) throws IOException {
        this.setVersion(n);
        this.writeShort(n);
    }

    @Override
    public void writeUTF(final String s) throws IOException {
        if (this.stringFlag) {
            this.writeString(s);
        }
        else {
            this.writeStringShort(s);
        }
    }
}
