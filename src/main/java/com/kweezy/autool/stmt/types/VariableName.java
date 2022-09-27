package com.kweezy.autool.stmt.types;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.interfaces.readWriteData;

import java.io.IOException;

public final class VariableName implements readWriteData, AutomateField {

    public static final VariableName[] x0;
    private int x1;
    private String str;

    static {
        x0 = new VariableName[0];
    }
    public VariableName() {
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
