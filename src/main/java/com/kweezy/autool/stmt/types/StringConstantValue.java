package com.kweezy.autool.stmt.types;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.Formatting;
import com.kweezy.autool.stmt.interfaces.customValue;

import java.io.IOException;

public final class StringConstantValue implements customValue<String> {

    public String str;

    public StringConstantValue() {
    }

    public StringConstantValue(final CharSequence charSequence) {
        this.str = charSequence.toString();
    }

    public StringConstantValue(final String str) {
        this.str = str;
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
