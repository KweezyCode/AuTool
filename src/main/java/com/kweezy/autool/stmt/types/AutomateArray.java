package com.kweezy.autool.stmt.types;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.interfaces.AutomateField;

import java.io.IOException;

public final class AutomateArray implements AutomateField {
    public AutomateField[] x0;

    public AutomateArray() {
        this.x0 = AutomateField.c;
    }

    @Override
    public void readData(final ObjectReader a) throws IOException {
        int h = a.unsigned_35();
        if (h > 0) {
            this.x0 = new AutomateField[h];
            int n = 0;
            while (--h >= 0) {
                this.x0[n] = a.readObject();
                ++n;
            }
        }
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        int length = this.x0.length;
        b.unsigned_35(length);
        int n = 0;
        while (--length >= 0) {
            b.writeObject(this.x0[n]);
            ++n;
        }
    }
    @Override
    public String prettyPrint(final int n) {
        final StringBuilder sb = new StringBuilder();
        final int n2 = n & 0x8;
        if (n2 == 0) {
            sb.append('[');
        }
        final AutomateField[] x0 = this.x0;
        final int length = x0.length;
        int i = 0;
        String str = "";
        while (i < length) {
            final AutomateField v0 = x0[i];
            sb.append(str);
            sb.append(v0.prettyPrint(n & 0xFFFFFFF7));
            ++i;
            str = ", ";
        }
        if (n2 == 0) {
            sb.append(']');
        }
        return sb.toString();
    }
}