package com.kweezy.stmt;

import com.kweezy.stmt.interfaces.functionName;

public abstract class BinaryFunction extends TwoFields implements functionName
{
    @Override
    public String prettyPrint(final int n) {
        return Formatting.n0(n, this.getFunctionName(), super.first, super.second);
    }
}
