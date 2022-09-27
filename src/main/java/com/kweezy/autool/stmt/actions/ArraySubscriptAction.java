package com.kweezy.autool.stmt.actions;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.VariableName;

import java.io.IOException;

public abstract class ArraySubscriptAction extends Action {
    public AutomateField index;
    public VariableName varArray;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.index = a.readObject();
        this.varArray = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.index);
        b.writeObject(this.varArray);
    }
}
