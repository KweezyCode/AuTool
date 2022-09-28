package com.kweezy.autool.stmt.types;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.interfaces.AutomateField;

import java.io.IOException;

public class e0 implements AutomateField { // Dictionary??? // TODO: Rename
    public AutomateField[] x0;
    public ConversionType[] x1;
    public AutomateField[] y0;

    public e0() {
        final AutomateField[] c = AutomateField.c;
        this.x0 = c;
        this.y0 = c;
        this.x1 = ConversionType.EMPTY_ARRAY;
    }


    @Override
    public void readData(final ObjectReader a) throws IOException {
        int h = a.unsigned_35();
        if (h != 0) {
            this.x0 = new AutomateField[h];
            this.y0 = new AutomateField[h];
            this.x1 = new ConversionType[h];
            int n = 0;
            while (--h >= 0) {
                this.x0[n] = a.readObject();
                this.y0[n] = a.readObject();
                this.x1[n] = ConversionType.readObject(a);
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
            b.writeObject(this.y0[n]);
            ConversionType.writeObject(b, this.x1[n]);
            ++n;
        }
    }

    @Override
    public String prettyPrint(final int n) {
        int length = this.x0.length;
        final StringBuilder sb = new StringBuilder();
        final int n2 = n & 0x8;
        if (n2 == 0) {
            sb.append('{');
        }
        int n3 = 0;
        String str = "";
        while (--length >= 0) {
            sb.append(str);
            final AutomateField v0 = this.x0[n3];
            final int n4 = n & 0xFFFFFFF7;
            sb.append(v0.prettyPrint(n4));
            final ConversionType obj = this.x1[n3];
            if (obj != null) {
                sb.append(" as ");
                sb.append(obj);
            }
            sb.append(": ");
            sb.append(this.y0[n3].prettyPrint(n4));
            ++n3;
            str = ", ";
        }
        if (n2 == 0) {
            sb.append('}');
        }
        return sb.toString();
    }
}
