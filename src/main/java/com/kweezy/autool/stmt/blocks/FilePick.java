package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.Formatting;
import com.kweezy.autool.stmt.actions.ActivityDecision;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.interfaces.customValue;
import com.kweezy.autool.stmt.types.AutomateNumber;
import com.kweezy.autool.stmt.types.VariableName;

import java.io.IOException;

public final class FilePick extends ActivityDecision {
    public AutomateField allowNew;
    public AutomateField fileExtension;
    public AutomateField initialPath;
    public AutomateField types;
    public VariableName varPickedPath;
    public AutomateField writable;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.types = a.readObject();
        if (93 <= a.version()) {
            this.writable = a.readObject();
        }
        this.allowNew = a.readObject();
        if (93 > a.version()) {
            final AutomateField allowNew = this.allowNew;
            if (allowNew instanceof customValue && Formatting.h0(allowNew)) {
                this.writable = new AutomateNumber(1);
            }
        }
        if (84 <= a.version()) {
            this.fileExtension = a.readObject();
        }
        if (36 <= a.version()) {
            this.initialPath = a.readObject();
        }
        this.varPickedPath = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.types);
        if (93 <= b.version()) {
            b.writeObject(this.writable);
        }
        b.writeObject(this.allowNew);
        if (84 <= b.version()) {
            b.writeObject(this.fileExtension);
        }
        if (36 <= b.version()) {
            b.writeObject(this.initialPath);
        }
        b.writeObject(this.varPickedPath);
    }
}