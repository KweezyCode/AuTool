package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.types.VariableName;
import com.kweezy.autool.stmt.actions.ActivityDecision;
import com.kweezy.autool.stmt.interfaces.AutomateField;

import java.io.IOException;

// Block is ready
public class AccountPick extends ActivityDecision {
    public AutomateField accountType;
    public VariableName varPickedAccountName;
    public VariableName varPickedAccountType;

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