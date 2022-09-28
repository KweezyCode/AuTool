package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.Action;
import com.kweezy.autool.stmt.interfaces.AutomateField;

import java.io.IOException;

public final class LogAppend extends Action {
    public AutomateField message;
    public AutomateField whenLogging;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.message = a.readObject();
        if (36 <= a.version()) {
            this.whenLogging = a.readObject();
        }
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.message);
        if (36 <= b.version()) {
            b.writeObject(this.whenLogging);
        }
    }
}
