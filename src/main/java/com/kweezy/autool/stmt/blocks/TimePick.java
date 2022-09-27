package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.ActivityDecision;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.VariableName;

import java.io.IOException;

// Block is ready
public class TimePick extends ActivityDecision {
    public AutomateField initialTimeOfDay;
    public AutomateField style;
    public VariableName varTimeOfDay;


    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        if (62 <= a.version()) {
            this.style = a.readObject();
        }
        if (31 <= a.version()) {
            this.initialTimeOfDay = a.readObject();
        }
        this.varTimeOfDay = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        if (62 <= b.version()) {
            b.writeObject(this.style);
        }
        if (31 <= b.version()) {
            b.writeObject(this.initialTimeOfDay);
        }
        b.writeObject(this.varTimeOfDay);
    }
}