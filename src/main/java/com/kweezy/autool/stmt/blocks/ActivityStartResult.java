package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.ActivityIntentDecision;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.VariableName;

import java.io.IOException;

public final class ActivityStartResult extends ActivityIntentDecision
{
    public AutomateField activityOptions;
    public VariableName varResultExtras;
    public VariableName varResultUri;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        if (89 <= a.version()) {
            this.activityOptions = a.readObject();
        }
        this.varResultUri = a.readObject();
        this.varResultExtras = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        if (89 <= b.version()) {
            b.writeObject(this.activityOptions);
        }
        b.writeObject(this.varResultUri);
        b.writeObject(this.varResultExtras);
    }
}