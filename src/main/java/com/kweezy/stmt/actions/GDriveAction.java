package com.kweezy.stmt.actions;

import com.kweezy.ObjectReader;
import com.kweezy.ObjectWriter;
import com.kweezy.stmt.interfaces.AutomateField;

import java.io.IOException;

public abstract class GDriveAction extends Action // implements IntentStatement, AsyncStatement, Statement
{
    public AutomateField account;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.account = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.account);
    }
}