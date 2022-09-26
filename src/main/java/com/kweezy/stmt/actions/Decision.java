package com.kweezy.stmt.actions;

import com.kweezy.ObjectReader;
import com.kweezy.ObjectWriter;
import com.kweezy.stmt.AbstractStatement;
import com.kweezy.stmt.interfaces.BlockType;

import java.io.IOException;

public abstract class Decision extends AbstractStatement {

    public BlockType onNegative;

    public BlockType onPositive;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.onPositive = a.readObject();
        this.onNegative = a.readObject();
        this.C(a);
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.onPositive);
        b.writeObject(this.onNegative);
        this.K(b);
    }

    protected void C(final ObjectReader a) {
    }

    protected void K(final ObjectWriter b) {
    }

    protected final void B(final ObjectReader a, final int n) throws IOException {
        super.readData(a);
        this.onPositive = a.readObject();
        if (n <= a.version()) {
            this.onNegative = a.readObject();
        }
        this.C(a);
    }

    protected final void J(final ObjectWriter b, final int n) throws IOException {
        super.writeData(b);
        b.writeObject(this.onPositive);
        if (n <= b.version()) {
            b.writeObject(this.onNegative);
        }
        this.K(b);
    }
}
