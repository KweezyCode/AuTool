package com.kweezy.autool.stmt.types;

import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.fieldcount.TwoFields;

public final class LogicalOr extends TwoFields {
    public LogicalOr() {
    }

    public LogicalOr(final AutomateField v0, final AutomateField v2) {
        super(v0, v2);
    }

    @Override
    public String prettyPrint(final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.first.prettyPrint(n));
        sb.append(" || ");
        sb.append(super.second.prettyPrint(n));
        return sb.toString();
    }
}
