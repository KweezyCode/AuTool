package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.IntermittentDecision;
import com.kweezy.autool.stmt.interfaces.AutomateField;

import java.io.IOException;

public class LocationProviderEnabled extends IntermittentDecision // implements ReceiverStatement
{
    public AutomateField provider;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.provider = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.provider);
    }
}
