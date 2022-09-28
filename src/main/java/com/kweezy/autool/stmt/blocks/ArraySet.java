package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.ArraySubscriptAction;
import com.kweezy.autool.stmt.interfaces.AutomateField;

import java.io.IOException;

public class ArraySet extends ArraySubscriptAction {
    public AutomateField value;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.value = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.value);
    }
}