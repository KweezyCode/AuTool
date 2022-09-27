package com.kweezy.autool.stmt.types;

public class HexNumber extends AutomateNumber
{
    public HexNumber() {
    }

    public HexNumber(final int n) {
        super(n);
    }

    @Override
    public String prettyPrint(final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append("0x");
        sb.append(Integer.toHexString(this.intValue()));
        return sb.toString();
    }
}