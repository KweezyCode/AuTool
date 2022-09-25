package com.kweezy.stmt;

import com.kweezy.ObjectReader;
import com.kweezy.ObjectWriter;

import java.io.IOException;

public final class StringConstantValue implements i<String> {

    private String str;

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
    public String o(int p0) {
        return null;
    }

    @Override
    public String value() {
        return null;
    }
}
