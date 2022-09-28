package com.kweezy.autool.stmt.types.constants;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.interfaces.customValue;

public final class NullConstant implements customValue<Void>
{
    public static final NullConstant x0;

    static {
        x0 = new NullConstant();
    }

    private NullConstant() {
    }

    @Override
    public void readData(final ObjectReader a) {
    }

    @Override
    public void writeData(final ObjectWriter b) {
    }

    public Void value() {
        return null;
    }

    @Override
    public String prettyPrint(final int n) {
        String s;
        if ((n & 0x2) != 0x0) {
            s = "";
        }
        else {
            s = "null";
        }
        return s;
    }

    @Override
    public String toString() {
        return "null";
    }
}
