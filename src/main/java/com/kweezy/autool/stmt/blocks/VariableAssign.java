package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.Action;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.VariableName;

import java.io.IOException;

// Block is ready
public class VariableAssign extends Action {
    public AutomateField value;
    public VariableName variable;


    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.value = a.readObject();
        this.variable = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.value);
        b.writeObject(this.variable);
    }

}
