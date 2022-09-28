package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.Action;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.VariableName;

import java.io.IOException;

public final class FlowStart extends Action {
    public AutomateField flowUri;
    public AutomateField payload;
    public boolean stopWithParent;
    public VariableName varChildFiberUri;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        if (18 <= a.version()) {
            this.stopWithParent = a.readBoolean();
        }
        this.flowUri = a.readObject();
        this.payload = a.readObject();
        if (18 <= a.version()) {
            this.varChildFiberUri = a.readObject();
        }
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        if (18 <= b.version()) {
            b.writeBoolean(this.stopWithParent);
        }
        b.writeObject(this.flowUri);
        b.writeObject(this.payload);
        if (18 <= b.version()) {
            b.writeObject(this.varChildFiberUri);
        }
    }
}