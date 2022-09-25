package com.kweezy.stmt;

import com.kweezy.ObjectReader;

import java.io.IOException;

public abstract class Action extends AbstractStatement {

    public BlockType onComplete;
    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.onComplete = a.readObject();
    }

    //@Override
    //public void writeBlockData(final ObjectWriter b) {
    //    super.writeBlockData(b);
    //    b.writeObject(this.onComplete);
    //}
}
