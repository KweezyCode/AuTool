package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.EmailAction;
import com.kweezy.autool.stmt.interfaces.AutomateField;

import java.io.IOException;

public final class GmailSend extends EmailAction // implements AsyncStatement, Statement
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

