package com.kweezy.autool.stmt.types;

import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.fieldcount.ThreeFields;

public final class TernaryOperator extends ThreeFields
{
    public TernaryOperator() {
    }

    public TernaryOperator(final AutomateField v0, final AutomateField v2, final AutomateField v3) {
        super(v0, v2, v3);
    }

    @Override
    public String prettyPrint(final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.first.prettyPrint(n));
        sb.append(" ? ");
        sb.append(super.third.prettyPrint(n));
        sb.append(" : ");
        sb.append(super.second.prettyPrint(n));
        return sb.toString();
    }
}
