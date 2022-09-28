package com.kweezy.autool.stmt.types.fieldcount;

import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.fieldcount.TwoFields;

public abstract class CompareTwoFields extends TwoFields
{
    public CompareTwoFields() {
    }

    public CompareTwoFields(final AutomateField v0, final AutomateField v2) {
        super(v0, v2);
    }

    protected abstract boolean compare(final Object p0, final Object p1);

}
