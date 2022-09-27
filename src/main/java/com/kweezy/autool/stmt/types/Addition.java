package com.kweezy.autool.stmt.types;

public final class Addition extends TwoFields
{
    // public Double e(final y0 y0) {
    //     return Formatting.H0(super.x0.k1(y0)) + Formatting.H0(super.y0.k1(y0));
    // }

    @Override
    public String prettyPrint(final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.first.prettyPrint(n));
        sb.append(" + ");
        sb.append(super.second.prettyPrint(n));
        return sb.toString();
    }
}
