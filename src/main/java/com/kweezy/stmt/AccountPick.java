package com.kweezy.stmt;

import com.kweezy.ObjectReader;
import com.kweezy.ObjectWriter;
import com.kweezy.stmt.actions.ActivityDecision;
import com.kweezy.stmt.interfaces.AutomateField;

import java.io.IOException;

public class AccountPick extends ActivityDecision {
    public AutomateField accountType;
    public AutomateString varPickedAccountName;
    public AutomateString varPickedAccountType;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.accountType = a.readObject();
        this.varPickedAccountName = a.readObject();
        this.varPickedAccountType = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.accountType);
        b.writeObject(this.varPickedAccountName);
        b.writeObject(this.varPickedAccountType);
    }


}