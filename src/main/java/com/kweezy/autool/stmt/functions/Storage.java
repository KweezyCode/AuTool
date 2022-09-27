package com.kweezy.autool.stmt.functions;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.types.BinaryFunction;

import java.io.IOException;

public class Storage extends BinaryFunction {
    public static final String NAME = "storage";

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.b(a, 38);
    }

    @Override
    public String getFunctionName() {
        return "storage";
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.d(b, 38);
    }
}