package com.kweezy.autool.stmt.actions;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.blocks.AbstractStatement;
import com.kweezy.autool.stmt.interfaces.BlockType;

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
