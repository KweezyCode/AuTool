package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.Action;
import com.kweezy.autool.stmt.interfaces.AutomateField;

import java.io.IOException;

public final class AccountGenericAdd extends Action {
    public AutomateField accountName;
    public AutomateField password;
    public AutomateField username;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.accountName = a.readObject();
        this.username = a.readObject();
        this.password = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.accountName);
        b.writeObject(this.username);
        b.writeObject(this.password);
    }
}
