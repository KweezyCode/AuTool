package com.kweezy.autool.stmt.actions;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.interfaces.AutomateField;

import java.io.IOException;

public abstract class ActivityAction extends Action // implements StartActivityForResultStatement
{
    public AutomateField notificationChannelId;
    public AutomateField startActivity;
    public AutomateField timeout;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.timeout = a.readObject();
        this.startActivity = a.readObject();
        this.notificationChannelId = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.timeout);
        b.writeObject(this.startActivity);
        b.writeObject(this.notificationChannelId);
    }
}