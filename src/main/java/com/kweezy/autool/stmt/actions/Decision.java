package com.kweezy.autool.stmt.actions;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.blocks.AbstractStatement;
import com.kweezy.autool.stmt.interfaces.BlockType;

import java.io.IOException;

public abstract class Decision extends AbstractStatement {

    public BlockType onNegative;

    public BlockType onPositive;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.onPositive = a.readObject();
        this.onNegative = a.readObject();
        this.readDataEmpty(a);
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.onPositive);
        b.writeObject(this.onNegative);
        this.writeDataEmpty(b);
    }

    protected void readDataEmpty(final ObjectReader a) throws IOException {
    }

    protected void writeDataEmpty(final ObjectWriter b) throws IOException {
    }

    protected final void B(final ObjectReader a, final int n) throws IOException {
        super.readData(a);
        this.onPositive = a.readObject();
        if (n <= a.version()) {
            this.onNegative = a.readObject();
        }
        this.readDataEmpty(a);
    }

    protected final void J(final ObjectWriter b, final int n) throws IOException {
        super.writeData(b);
        b.writeObject(this.onPositive);
        if (n <= b.version()) {
            b.writeObject(this.onNegative);
        }
        this.writeDataEmpty(b);
    }
}
