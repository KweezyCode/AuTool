package com.kweezy.stmt;

import com.kweezy.ObjectReader;
import com.kweezy.ObjectWriter;
import com.kweezy.stmt.interfaces.i;

import java.io.IOException;

public final class StringConstantValue implements i<String> {

    public String str;

    public StringConstantValue() {
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
    public String prettyPrint(int p0) {
        return Formatting.constantString(this.str, p0);
    }

    @Override
    public String value() {
        return null;
    }
}
