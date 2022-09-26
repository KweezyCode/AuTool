package com.kweezy.stmt.actions;

import com.kweezy.ObjectReader;
import com.kweezy.ObjectWriter;

import java.io.IOException;

public abstract class IntermittentAction extends Action
{
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
}