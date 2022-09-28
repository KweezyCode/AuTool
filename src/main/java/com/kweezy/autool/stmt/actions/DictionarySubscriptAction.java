package com.kweezy.autool.stmt.actions;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.VariableName;

import java.io.IOException;

public abstract class DictionarySubscriptAction extends Action {
    public AutomateField key;
    public VariableName varDictionary;
    public VariableName varOldValue;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.key = a.readObject();
        this.varDictionary = a.readObject();
        if (2 <= a.version()) {
            this.varOldValue = a.readObject();
        }
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.key);
        b.writeObject(this.varDictionary);
        if (2 <= b.version()) {
            b.writeObject(this.varOldValue);
        }
    }
}