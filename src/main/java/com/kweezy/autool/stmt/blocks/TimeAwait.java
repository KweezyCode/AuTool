package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.IntermittentAction;
import com.kweezy.autool.stmt.interfaces.AutomateField;

import java.io.IOException;

// Block is ready
public class TimeAwait extends IntermittentAction { // implements IntentStatement, AsyncStatement, b3
    private int c4;
    public AutomateField dayOfMonth;
    public AutomateField months;
    public AutomateField timeOfDay;
    public AutomateField timeZone;
    public AutomateField wakeup;
    public AutomateField weekdays;
    public AutomateField year;

    public TimeAwait() {
        this.c4 = -1;
    }
    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.wakeup = a.readObject();
        this.timeZone = a.readObject();
        this.timeOfDay = a.readObject();
        this.weekdays = a.readObject();
        this.dayOfMonth = a.readObject();
        this.months = a.readObject();
        this.year = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.wakeup);
        b.writeObject(this.timeZone);
        b.writeObject(this.timeOfDay);
        b.writeObject(this.weekdays);
        b.writeObject(this.dayOfMonth);
        b.writeObject(this.months);
        b.writeObject(this.year);
    }
}