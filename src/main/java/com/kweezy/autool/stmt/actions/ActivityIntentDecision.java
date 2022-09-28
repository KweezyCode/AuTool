package com.kweezy.autool.stmt.actions;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.Formatting;
import com.kweezy.autool.stmt.interfaces.AutomateField;

import java.io.IOException;

public abstract class ActivityIntentDecision extends IntentDecision // implements StartActivityForResultStatement
{
    public AutomateField notificationChannelId;
    public AutomateField startActivity;
    public AutomateField timeout;

    @Override
    protected void readDataEmpty(final ObjectReader a) throws IOException {
        super.readDataEmpty(a);
        this.timeout = a.readObject();
        if (9 <= a.version()) {
            this.startActivity = a.readObject();
        }
        if (77 <= a.version()) {
            this.notificationChannelId = a.readObject();
        }
    }

    @Override
    protected void writeDataEmpty(final ObjectWriter b) throws IOException {
        super.writeDataEmpty(b);
        b.writeObject(this.timeout);
        if (9 <= b.version()) {
            b.writeObject(this.startActivity);
        }
        if (77 <= b.version()) {
            b.writeObject(this.notificationChannelId);
        }
    }
}
