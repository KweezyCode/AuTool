package com.kweezy.stmt.actions;

import com.kweezy.ObjectReader;
import com.kweezy.ObjectWriter;
import com.kweezy.stmt.interfaces.AutomateField;

import java.io.IOException;

public abstract class ActivityDecision extends Decision { // implements StartActivityForResultStatement
    public AutomateField notificationChannelId;
    public AutomateField startActivity;
    public AutomateField timeout;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.timeout = a.readObject();
        if (9 <= a.version()) {
            this.startActivity = a.readObject();
        }
        if (77 <= a.version()) {
            this.notificationChannelId = a.readObject();
        }
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.timeout);
        if (9 <= b.version()) {
            b.writeObject(this.startActivity);
        }
        if (77 <= b.version()) {
            b.writeObject(this.notificationChannelId);
        }
    }
}
