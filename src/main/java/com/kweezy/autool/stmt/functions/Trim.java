package com.kweezy.autool.stmt.functions;

import com.kweezy.autool.stmt.types.UnaryFunction;

public final class Trim extends UnaryFunction
{
    public static final String NAME = "trim";

    @Override
    public String getFunctionName() {
        return "trim";
    }

}
