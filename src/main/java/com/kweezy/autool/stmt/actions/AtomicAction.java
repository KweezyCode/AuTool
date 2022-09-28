package com.kweezy.autool.stmt.actions;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.types.VariableName;

import java.io.IOException;

public abstract class AtomicAction extends Action {
    public VariableName varAtomic;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.varAtomic = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.varAtomic);
    }
}
