package com.kweezy.autool.stmt.types;

import com.kweezy.autool.stmt.Formatting;
import com.kweezy.autool.stmt.interfaces.functionName;
import com.kweezy.autool.stmt.types.fieldcount.ThreeFields;

public abstract class TernaryFunction extends ThreeFields implements functionName
{
    @Override
    public String prettyPrint(final int n) {
        return Formatting.n0(n, this.getFunctionName(), super.first, super.third, super.second);
    }
}
