package com.kweezy.autool.stmt.types;

import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.CompareTwoFields;

public final class Equals extends CompareTwoFields {
    public Equals() {
    }

    public Equals(final AutomateField v0, final AutomateField v2) {
        super(v0, v2);
    }

    public static boolean h(final Object o, final Object obj) {
        final boolean b = true;
        boolean b2 = true;
        if (o == null) {
            if (obj != null) {
                b2 = false;
            }
            return b2;
        }
        if (obj instanceof Comparable && o.getClass() == obj.getClass()) {
            return ((Comparable)o).compareTo(obj) == 0 && b;
        }
        return o.equals(obj);
    }

    @Override
    protected boolean compare(final Object o, final Object o2) {
        return h(o, o2);
    }

    @Override
    public String prettyPrint(final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.first.prettyPrint(n));
        sb.append(" = ");
        sb.append(super.second.prettyPrint(n));
        return sb.toString();
    }
}