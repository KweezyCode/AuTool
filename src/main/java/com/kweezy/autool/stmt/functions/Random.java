package com.kweezy.autool.stmt.functions;

import com.kweezy.autool.stmt.types.UnaryFunction;

public final class Random extends UnaryFunction {
    public static final String NAME = "random";

    @Override
    public String getFunctionName() {
        return "random";
    }
}
