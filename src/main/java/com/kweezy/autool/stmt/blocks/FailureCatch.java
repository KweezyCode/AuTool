package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.Action;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.interfaces.BlockType;
import com.kweezy.autool.stmt.types.VariableName;

import java.io.IOException;

public final class FailureCatch extends Action // implements b3
{
    private int c4;

    public BlockType onFailure;
    public AutomateField retryLimit;
    public VariableName varFailureMessage;
    public VariableName varFailureStatementId;
    public VariableName varFailureType;
    public VariableName varRetryCount;

    public FailureCatch() {
        this.c4 = -1;
    }

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.onFailure = a.readObject();
        this.retryLimit = a.readObject();
        this.varRetryCount = a.readObject();
        this.varFailureStatementId = a.readObject();
        this.varFailureType = a.readObject();
        this.varFailureMessage = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.onFailure);
        b.writeObject(this.retryLimit);
        b.writeObject(this.varRetryCount);
        b.writeObject(this.varFailureStatementId);
        b.writeObject(this.varFailureType);
        b.writeObject(this.varFailureMessage);
    }

    // @Override
    // public void b(final c3 c3) {
    //     this.c4 = c3.d(false);
    // }
}

