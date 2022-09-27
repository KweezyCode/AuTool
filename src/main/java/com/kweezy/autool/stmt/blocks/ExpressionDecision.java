package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.Decision;
import com.kweezy.autool.stmt.interfaces.AutomateField;

import java.io.IOException;

// Block is ready
public class ExpressionDecision extends Decision {
    public AutomateField expression;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.expression = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.expression);
    }
}