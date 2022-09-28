package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.ActivityDecision;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.VariableName;

import java.io.IOException;

public class DialogNumber extends ActivityDecision {
    public AutomateField initialValue;
    public AutomateField maxValue;
    public AutomateField minValue;
    public AutomateField style;
    public AutomateField title;
    public VariableName varResultValue;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.style = a.readObject();
        this.title = a.readObject();
        this.minValue = a.readObject();
        this.maxValue = a.readObject();
        this.initialValue = a.readObject();
        this.varResultValue = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.style);
        b.writeObject(this.title);
        b.writeObject(this.minValue);
        b.writeObject(this.maxValue);
        b.writeObject(this.initialValue);
        b.writeObject(this.varResultValue);
    }
}