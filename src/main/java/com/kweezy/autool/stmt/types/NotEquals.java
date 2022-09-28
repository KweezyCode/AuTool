package com.kweezy.autool.stmt.types;

import com.kweezy.autool.stmt.types.Equals;
import com.kweezy.autool.stmt.types.fieldcount.CompareTwoFields;

public final class NotEquals extends CompareTwoFields
{
    public static boolean h(final Object o, final Object o2) {
        return Equals.h(o, o2) ^ true;
    }

    @Override
    protected boolean compare(final Object o, final Object o2) {
        return h(o, o2);
    }

    @Override
    public String prettyPrint(final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.first.prettyPrint(n));
        sb.append(" != ");
        sb.append(super.second.prettyPrint(n));
        return sb.toString();
    }
}