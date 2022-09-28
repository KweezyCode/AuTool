package com.kweezy.autool.stmt.functions;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.types.TernaryFunction;

import java.io.IOException;

public class Contains extends TernaryFunction
{
    public static final String NAME = "contains";


    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.b(a, 22);
    }

    @Override
    public String getFunctionName() {
        return "contains";
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.d(b, 22);
    }

}
