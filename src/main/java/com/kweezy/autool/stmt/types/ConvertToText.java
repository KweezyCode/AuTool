package com.kweezy.autool.stmt.types;

import com.kweezy.autool.stmt.types.fieldcount.OneField;

public final class ConvertToText extends OneField
{
    @Override
    public String prettyPrint(final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append("++");
        sb.append(super.first.prettyPrint(n));
        return sb.toString();
    }
}
