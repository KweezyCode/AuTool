package com.kweezy.autool.stmt.types;

import com.kweezy.autool.stmt.types.fieldcount.CompareTwoFields;

public final class LessThan extends CompareTwoFields
{
    public static boolean h(final Object o, final Object o2) {
        final boolean b = true;
        boolean b2 = true;
        if (o == null) {
            if (o2 == null) {
                b2 = false;
            }
            return b2;
        }
        return o2 != null && o instanceof Comparable && o.getClass() == o2.getClass() && ((Comparable)o).compareTo(o2) < 0 && b;
    }

    @Override
    protected boolean compare(final Object o, final Object o2) {
        return h(o, o2);
    }

    @Override
    public String prettyPrint(final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.first.prettyPrint(n));
        sb.append(" < ");
        sb.append(super.second.prettyPrint(n));
        return sb.toString();
    }
}

