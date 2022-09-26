package com.kweezy.stmt;

import com.kweezy.ObjectReader;
import com.kweezy.ObjectWriter;
import com.kweezy.stmt.interfaces.AutomateField;
import com.kweezy.stmt.interfaces.readWriteData;

import java.io.IOException;

public final class AutomateString implements readWriteData, AutomateField {

    public static final AutomateString[] x0;
    private int x1;
    private String str;

    static {
        x0 = new AutomateString[0];
    }
    public AutomateString() {
    }

    @Override
    public void readData(final ObjectReader a) throws IOException {
        this.str = a.readUTF();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        b.writeUTF(this.str);
    }

    @Override
    public String prettyPrint(final int n) {
        return this.str;
    }

}
