package com.kweezy.autool.stmt.actions;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;

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