package com.kweezy.stmt;

public class SubscriptOperator extends TwoFields {

    @Override
    public String prettyPrint(final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.first.prettyPrint(n));
        sb.append("[");
        sb.append(super.second.prettyPrint(n));
        sb.append("]");
        return sb.toString();
    }
}
