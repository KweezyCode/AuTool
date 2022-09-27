package com.kweezy.autool.stmt.functions;

import com.kweezy.autool.stmt.types.UnaryFunction;

public final class JsonDecode extends UnaryFunction {
    public static final String NAME = "jsonDecode";

    @Override
    public String getFunctionName() {
        return "jsonDecode";
    }
}

