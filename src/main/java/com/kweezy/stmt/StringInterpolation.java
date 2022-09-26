package com.kweezy.stmt;

import com.kweezy.ObjectReader;
import com.kweezy.ObjectWriter;
import com.kweezy.stmt.interfaces.AutomateField;

import java.io.IOException;

public final class StringInterpolation implements AutomateField {
    public String[] x0;
    public byte[] x1;
    public AutomateField[] arrayOfAutomateFields;
    public StringInterpolation() {
    }

    public StringInterpolation(final int n) {
        this.x0 = new String[n + 1];
        this.arrayOfAutomateFields = new AutomateField[n];
        this.x1 = new byte[n / 8 + 1];
    }

    @Override
    public void readData(final ObjectReader a) throws IOException {
        int h = a.unsigned_35();
        this.x0 = new String[h];
        final int n = 0;
        for (int i = 0; i < h; ++i) {
            this.x0[i] = a.readUTF();
        }
        --h;
        this.arrayOfAutomateFields = new AutomateField[h];
        for (int j = 0; j < h; ++j) {
            this.arrayOfAutomateFields[j] = a.readObject();
        }
        final int n2 = h / 8 + 1;
        this.x1 = new byte[n2];
        for (int k = n; k < n2; ++k) {
            this.x1[k] = a.readByte();
        }
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        int length = this.x0.length;
        b.unsigned_35(length);
        final int n = 0;
        for (int i = 0; i < length; ++i) {
            b.writeUTF(this.x0[i]);
        }
        --length;
        for (int j = 0; j < length; ++j) {
            b.writeObject(this.arrayOfAutomateFields[j]);
        }
        for (int n2 = length / 8, k = n; k < n2 + 1; ++k) {
            b.writeByte(this.x1[k]);
        }
    }

    @Override
    public String prettyPrint(final int n) {
        final StringBuilder sb = new StringBuilder();
        final int n2 = n & 0x1;
        if (n2 == 0) {
            sb.append('\"');
        }
        int length = this.x0.length;
        int n3 = -1;
        while (--length > 0) {
            final String[] x0 = this.x0;
            final int n4 = n3 + 1;
            Formatting.c(x0[n4], n, sb);
            sb.append('{');
            final AutomateField automatefield = this.arrayOfAutomateFields[n4];
            if (automatefield != null) {
                int n5;
                if ((1 << n4 % 8 & this.x1[n4 / 8]) != 0x0) {
                    n5 = (n | 0x1);
                }
                else {
                    n5 = (n & 0xFFFFFFFA);
                }
                sb.append(automatefield.prettyPrint(n5));
            }
            sb.append('}');
            n3 = n4;
        }
        Formatting.c(this.x0[n3 + 1], n, sb);
        if (n2 == 0) {
            sb.append('\"');
        }
        return sb.toString();
    }
}