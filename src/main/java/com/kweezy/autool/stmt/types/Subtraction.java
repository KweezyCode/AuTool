package com.kweezy.autool.stmt.types;

import com.kweezy.autool.stmt.types.fieldcount.TwoFields;

public final class Subtraction extends TwoFields
{
    @Override
    public String prettyPrint(final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.first.prettyPrint(n));
        sb.append(" - ");
        sb.append(super.second.prettyPrint(n));
        return sb.toString();
    }
}
