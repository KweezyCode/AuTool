package com.kweezy.autool.stmt.types;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.interfaces.AutomateField;

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
