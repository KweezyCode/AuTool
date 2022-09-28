package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.Action;
import com.kweezy.autool.stmt.interfaces.AutomateField;

import java.io.IOException;

public final class FlowStop extends Action {
    public AutomateField flowUri;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.B(a, 26);
        if (26 <= a.version()) {
            this.flowUri = a.readObject();
        }
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.C(b, 26);
        if (26 <= b.version()) {
            b.writeObject(this.flowUri);
        }
    }
}