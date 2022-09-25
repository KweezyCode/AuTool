package com.kweezy.stmt;

import com.kweezy.ObjectReader;

import java.io.IOException;

public final class StringConstantValue implements i<String> {

    private String str;

    public StringConstantValue() {
    }

    @Override
    public void readData(final ObjectReader a) throws IOException {

        this.str = a.readUTF();
        System.out.println("[Debug] StringConst \"" + str + "\"");
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
