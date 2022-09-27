package com.kweezy.autool.stmt.types;

import com.kweezy.autool.stmt.Formatting;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.interfaces.functionName;

public abstract class UnaryFunction extends OneField implements functionName
{
    public UnaryFunction() {
    }

    public UnaryFunction(final AutomateField v0) {
        super(v0);
    }

    @Override
    public String prettyPrint(final int n) {
        return Formatting.n0(n, this.getFunctionName(), super.first);
    }
}
