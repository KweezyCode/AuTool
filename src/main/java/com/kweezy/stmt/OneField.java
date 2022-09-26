package com.kweezy.stmt;

import com.kweezy.ObjectReader;
import com.kweezy.ObjectWriter;
import com.kweezy.stmt.interfaces.AutomateField;

import java.io.IOException;

public abstract class OneField implements AutomateField
{
    public AutomateField first;

    public OneField() {
    }

    public OneField(final AutomateField first) {
        this.first = first;
    }

    @Override
    public void readData(final ObjectReader a) throws IOException {
        this.first = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        b.writeObject(this.first);
    }

}
