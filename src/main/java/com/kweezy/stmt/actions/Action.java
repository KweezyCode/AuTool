package com.kweezy.stmt.actions;

import com.kweezy.ObjectReader;
import com.kweezy.ObjectWriter;
import com.kweezy.stmt.AbstractStatement;
import com.kweezy.stmt.interfaces.BlockType;

import java.io.IOException;

public abstract class Action extends AbstractStatement {

    public BlockType onComplete;
    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.onComplete = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.onComplete);
    }
}
