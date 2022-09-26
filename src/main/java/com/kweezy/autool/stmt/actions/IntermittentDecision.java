package com.kweezy.autool.stmt.actions;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;

import java.io.IOException;

public class IntermittentDecision extends Decision { // implements IntermittentStatement {
    public Integer continuity;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.continuity = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.continuity);
    }

    protected final void readContinuity(final ObjectReader a, final int n) throws IOException {
        super.B(a, n);
        this.continuity = a.readObject();
    }

    protected final void W(final ObjectWriter b, final int n) throws IOException {
        super.J(b, n);
        b.writeObject(this.continuity);
    }

}
