package com.kweezy.autool.stmt.functions;

import com.kweezy.autool.stmt.types.UnaryFunction;

public class JsonEncode extends UnaryFunction {
    public static final String NAME = "jsonEncode";

    @Override
    public String getFunctionName() {
        return "jsonEncode";
    }

}
