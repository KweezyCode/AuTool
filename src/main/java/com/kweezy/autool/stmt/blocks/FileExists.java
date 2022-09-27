package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.IntermittentDecision;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.VariableName;

import java.io.IOException;

// Block is ready
public final class FileExists extends IntermittentDecision // implements AsyncStatement
{
    public AutomateField path;
    public VariableName varLastModified;
    public VariableName varSize;
    public VariableName varType;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.path = a.readObject();
        if (56 <= a.version()) {
            this.varType = a.readObject();
        }
        if (22 <= a.version()) {
            this.varSize = a.readObject();
            this.varLastModified = a.readObject();
        }
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.path);
        if (56 <= b.version()) {
            b.writeObject(this.varType);
        }
        if (22 <= b.version()) {
            b.writeObject(this.varSize);
            b.writeObject(this.varLastModified);
        }
    }
}