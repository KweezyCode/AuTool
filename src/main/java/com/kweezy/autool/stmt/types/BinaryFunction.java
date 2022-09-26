package com.kweezy.autool.stmt.types;

import com.kweezy.autool.stmt.Formatting;
import com.kweezy.autool.stmt.interfaces.functionName;
import com.kweezy.autool.stmt.types.TwoFields;

public abstract class BinaryFunction extends TwoFields implements functionName
{
    @Override
    public String prettyPrint(final int n) {
        return Formatting.n0(n, this.getFunctionName(), super.first, super.second);
    }
}
