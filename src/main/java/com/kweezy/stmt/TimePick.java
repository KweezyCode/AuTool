package com.kweezy.stmt;

import com.kweezy.ObjectReader;
import com.kweezy.ObjectWriter;
import com.kweezy.stmt.actions.ActivityDecision;
import com.kweezy.stmt.interfaces.AutomateField;

import java.io.IOException;

public class TimePick extends ActivityDecision {
    public AutomateField initialTimeOfDay;
    public AutomateField style;
    public AutomateString varTimeOfDay;


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